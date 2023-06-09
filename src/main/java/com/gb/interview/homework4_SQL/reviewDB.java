package com.gb.interview.homework4_SQL;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class reviewDB {

    private static Connection connection;
    private static Statement statement;

    private static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    private static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");




    public static void main(String[] args) throws SQLException {

        try {
            start();

            // https://antonz.ru/window-offset/  - это себе на память подробно об оконных фунлциях

            // Расписание на заданную дату по всем кинозалам вместе сортированное по времени начала сеанса
            String searchDate = "27 апреля 2023";
            getSchedule(searchDate);


            // Проверка на пересечение старта следующего фильма раньше окончания предыдущего по каждому кинозалу:
            sequenceChecking();


            // Перерывы между фильмами во всех кинозалах одним запросом группированные по кинозалу и сортированные по длительности:
            timeoutChecking();


            // Список фильмов с количеством проданных на него билетов, средним числом билетов на него за сеанс и суммарной выручкой от каждого фильма. В конце общая выручка методом java
            totalPrice();


            // Аналитика по времени: количество посетителей и выручка распределенная по временным интервалам одним запросом
            timeStatistic();


        } catch (ClassNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        } finally {
            stop();
        }
    }

    private static void timeStatistic() throws SQLException {
        System.out.println("\n\nСтатистика посещаемости по временным интервалам:");
        String resultRequest = "select \"с  9.00\" as 'from', \"до 15.00\" as 'to', count(*) as count, sum(price) as sum\n" +
                "from tickets as t\n" +
                "left join schedule as s\n" +
                "on t.seans_id = s.id\n" +
                "where hour(s.date_time) >= 9 and hour(s.date_time) < 15\n" +
                "union \n" +
                "select \"с 15.00\" as 'from', \"до 18.00\" as 'to', count(*) as count, sum(price) as sum\n" +
                "from tickets as t\n" +
                "left join schedule as s\n" +
                "on t.seans_id = s.id\n" +
                "where hour(s.date_time) >= 15 and hour(s.date_time) < 18\n" +
                "union \n" +
                "select \"с 18.00\" as 'from', \"до 21.00\" as 'to', count(*) as count, sum(price) as sum\n" +
                "from tickets as t\n" +
                "left join schedule as s\n" +
                "on t.seans_id = s.id\n" +
                "where hour(s.date_time) >= 18 and hour(s.date_time) < 21\n" +
                "union \n" +
                "select \"с 21.00\" as 'from', \"до --\" as 'to', count(*) as count, sum(price) as sum\n" +
                "from tickets as t\n" +
                "left join schedule as s\n" +
                "on t.seans_id = s.id\n" +
                "where hour(s.date_time) >= 21;";

        ResultSet resultSet = statement.executeQuery(resultRequest);
        while (resultSet.next()){
            System.out.printf("%s  %s  посетителей: %d, выручка: %.2f рублей\n",
                    resultSet.getString("from"),
                    resultSet.getString("to"),
                    resultSet.getInt("count"),
                    resultSet.getDouble("sum"));
        }
    }

    private static void totalPrice() throws SQLException {
        System.out.println("\n\nИтоги показов:");
        String resultRequest = "with w as(\n" +
                "select s.movie_id, count(*) as count, sum(t.price) as pr\n" +
                "from schedule as s\n" +
                "inner join tickets as t\n" +
                "on t.seans_id = s.id\n" +
                "group by s.id\n" +
                "order by s.movie_id\n" +
                ") \n" +
                "select m.title, sum(count) as count, avg(count) as avg, sum(pr) as sum\n" +
                "from w\n" +
                "left join movies as m\n" +
                "on movie_id = m.id\n" +
                "group by movie_id\n" +
                "order by sum desc;";

        ResultSet resultSet = statement.executeQuery(resultRequest);


        double totalSum = 0;
        while (resultSet.next()){
            totalSum += resultSet.getDouble("sum");
            System.out.printf("Фильм \"%s\" посетили %d человек, в среднем %.2f за сеанс, фильм собрал %.2f рублей\n",
                    resultSet.getString("title"),
                    resultSet.getInt("count"),
                    resultSet.getDouble("avg"),
                    resultSet.getDouble("sum"));
        }
        System.out.println("Общая выручка по кинотеатру: " + totalSum);
    }

    private static void timeoutChecking() throws SQLException {
        System.out.println("\n\nПерерывы между фильмами:");
        String timeoutRequest = "with emp as (\n" +
                "            select s.id, m.title, s.date_time, m.duration, s.sinema_hall,\n" +
                "            addtime(s.date_time, m.duration) as full_duration,\n" +
                "            timediff(lead(date_time, 1) over w, addtime(s.date_time, m.duration)) as 'gap',\n" +
                "            lead(date_time, 1) over w as next,\n" +
                "            lead(m.title, 1) over w as next_movie\n" +
                "            from schedule as s\n" +
                "            left join movies as m\n" +
                "            on s.movie_id = m.id\n" +
                "            window w as(partition by s.sinema_hall)\n" +
                "            order by gap\n" +
                "            )\n" +
                "            select id, title, date_time, duration, full_duration, gap, next, next_movie, sinema_hall\n" +
                "            from emp\n" +
                "            where gap is not null\n" +  // если в точности как в задании - вывести ТОЛЬКО перерывы больше 30 минут, то тут надо так: where gap > "00:30:00"
                "            order by sinema_hall, gap desc;";

        ResultSet timeoutSet = statement.executeQuery(timeoutRequest);

        while (timeoutSet.next()){
            System.out.printf("Фильм \"%s\", кинозал № %d, начало %s, продолжительность %s, окончание %s, перерыв между сеансами %s, следующий фильм \"%s\", начало следующего фильма %s\n",
                    timeoutSet.getString("title"),
                    timeoutSet.getInt("sinema_hall"),
                    timeoutSet.getTimestamp("date_time"),
                    timeoutSet.getTime("duration"),
                    timeoutSet.getTimestamp("full_duration"),
                    timeoutSet.getTime("gap"),
                    timeoutSet.getString("next_movie"),
                    timeoutSet.getTimestamp("next"));
        }
    }

    private static void sequenceChecking() throws SQLException {
        System.out.println("\n\nПроверка расписания на накладки:");
        ResultSet resultSet = statement.executeQuery("select sinema_hall from schedule group by sinema_hall;");
        ArrayList<Integer> hall = new ArrayList<>();
        while (resultSet.next()){
            hall.add(resultSet.getInt(1));
        }


        for (Integer integer : hall) {
            resultSet = statement.executeQuery(String.format("with emp as (\n" +
                    "            select s.id, m.title, s.date_time, m.duration,\n" +
                    "            addtime(s.date_time, m.duration) as full_duration,\n" +
                    "            timediff(lead(date_time, 1) over (), addtime(s.date_time, m.duration)) as 'gap',\n" +
                    "            lead(date_time, 1) over () as next,\n" +
                    "            lead(m.title, 1) over () as next_movie\n" +
                    "            from schedule as s\n" +
                    "            left join movies as m\n" +
                    "            on s.movie_id = m.id\n" +
                    "            where s.sinema_hall = %d\n" +
                    "            )\n" +
                    "            select id, title, date_time, duration, full_duration, gap, next, next_movie\n" +
                    "            from emp\n" +
                    "            where gap < 0\n" +
                    "            order by gap desc;", integer));
            if (!resultSet.isBeforeFirst()){
                System.out.printf("В кинозале № %d накладок с расписанием не обнаружено.\n", integer);
            } else {
                System.out.printf("В кинозале № %d обнаружены следующие накладки:\n", integer);
                while (resultSet.next()){
                    System.out.printf("Сеанс фильма \"%s\" начавшийся %s с продолжительностью %s заканчивается %s перекрывается на %s с сеансом фильма \"%s\" начинающимся %s\n",
                            resultSet.getString("title"),
                            resultSet.getTimestamp("date_time"),
                            resultSet.getTime("duration"),
                            resultSet.getTimestamp("full_duration"),
                            resultSet.getTime("gap"),
                            resultSet.getString("next_movie"),
                            resultSet.getTimestamp("next"));
                }
            }
        }
    }

    private static void getSchedule(String date) throws SQLException, ParseException {
        GregorianCalendar searchDate = new GregorianCalendar();
        searchDate.setTime(dateFormat.parse(date));

        System.out.printf("Расписание на дату: %s\n\n",
                dateFormat.format(searchDate.getTime()));
        Calendar secondDate = new GregorianCalendar();
        secondDate.setTime(searchDate.getTime());
        secondDate.roll(Calendar.DAY_OF_MONTH, 1);
        ResultSet schedule = statement.executeQuery(String.format("select m.title, s.date_time, s.sinema_hall, m.duration\n" +
                "            from test.schedule as s\n" +
                "            left join test.movies as m\n" +
                "            on s.movie_id = m.id\n" +
                "            where s.date_time between \"%s\" and \"%s\"\n" +
                "            order by s.date_time;",
                dateTimeFormat.format(searchDate.getTime()),
                dateTimeFormat.format(secondDate.getTime())
                ));
        while (schedule.next()){
            System.out.printf("\"%s\"   начало: %s кинозал № %d   продолжительность %s\n",
                    schedule.getString("title"),
                    timeFormat.format(schedule.getTimestamp("date_time")),
                    schedule.getInt("sinema_hall"),
                    schedule.getTime("duration"));
        }
    }

    public static void start() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "6830");
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "312808895");
        statement = connection.createStatement();
    }

    public static void stop() throws SQLException {
        statement.close();
        connection.close();
    }

}
