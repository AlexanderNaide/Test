package com.gb.interview.homework4_SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class createDB {

    private static Connection connection;
    private static Statement statement;



    public static void main(String[] args) throws SQLException {

        try {
            start();

            createMovies();

            createSeances();

            int totalTickets = 250;

            generateTickets(totalTickets);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            stop();
        }
    }

    private static void generateTickets(int count) throws SQLException {
        String createTableTickets = "CREATE TABLE IF NOT EXISTS `test`.`tickets` (\n" +
                "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `seans_id` BIGINT UNSIGNED NULL,\n" +
                "  `line` INT NULL,\n" +
                "  `place` INT NULL,\n" +
                "  `price` DOUBLE NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_tickets_shedule_idx` (`seans_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_tickets_shedule`\n" +
                "    FOREIGN KEY (`seans_id`)\n" +
                "    REFERENCES `test`.`schedule` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);";
        statement.execute(createTableTickets);

        double basePrice = 250.0;

        ResultSet resultSet = statement.executeQuery("select id, date_time from `test`.`schedule`");
        Map<Long, Double[][]> schedule = new HashMap<>();
        Map<Long, Double> prices = new HashMap<>();

        while (resultSet.next()){
            long n = resultSet.getLong("id");
            Timestamp time = resultSet.getTimestamp("date_time");
            if (time.getHours() > 20){
                prices.put(n, basePrice * 2);
            } else if (time.getHours() > 15) {
                prices.put(n, basePrice * 1.5);
            } else {
                prices.put(n, basePrice);
            }
            schedule.put(resultSet.getLong("id"), new Double[14][20]);
        }
        for (int i = 0; i < count; i++) {
            Long s = (long) (Math.random() * schedule.size()) + 1;
            double price = prices.get(s);
            int line;
            int place;
            while(true){
                line = (int) (Math.random() * 14);
                place = (int) (Math.random() * 20);
                if (schedule.get(s)[line][place] == null){
                    if (line > 5 && place > 5 && place < 16){
                        price = price * 1.5;
                    }
                    schedule.get(s)[line][place] = price;
                    statement.execute(String.format(Locale.US, "INSERT INTO `test`.`tickets` (`seans_id`, `line`, `place`, `price`) VALUES ('%d', '%d', '%d', '%.2f');", s, line + 1, place + 1, price));
                    break;
                }
            }
        }
    }

    private static void createSeances() throws SQLException {
        String createTableSchedule = "CREATE TABLE IF NOT EXISTS `test`.`schedule` (\n" +
                "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `movie_id` BIGINT UNSIGNED NOT NULL,\n" +
                "  `date_time` TIMESTAMP NULL,\n" +
                "  `sinema_hall` INT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_sch_movies_idx` (`movie_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_sch_movies`\n" +
                "    FOREIGN KEY (`movie_id`)\n" +
                "    REFERENCES `test`.`movies` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);";
        statement.execute(createTableSchedule);

        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('1', '2023-04-27 11:00:00', '1');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('3', '2023-04-27 11:00:00', '2');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('2', '2023-04-27 14:00:00', '1');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('2', '2023-04-27 12:45:00', '2');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('3', '2023-04-27 17:00:00', '1');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('1', '2023-04-27 15:45:00', '2');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('1', '2023-04-27 18:30:00', '1');"); // вот тут будет перекрытие времени, потом будем это отлавливать
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('2', '2023-04-27 18:40:00', '2');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('2', '2023-04-27 22:00:00', '1');");
        statement.execute("INSERT INTO `test`.`schedule` (`movie_id`, `date_time`, `sinema_hall`) VALUES ('1', '2023-04-27 21:40:00', '2');");
    }

    private static void createMovies() throws SQLException {
        statement.execute("CREATE SCHEMA IF NOT EXISTS `test`");
        String createTableMovies = "CREATE TABLE IF NOT EXISTS `test`.`movies` (\n" +
                "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `title` VARCHAR(85) NOT NULL,\n" +
                "  `duration` TIME NULL,\n" +
                "  `description` VARCHAR(1200) NULL,\n" +
                "  PRIMARY KEY (`id`));";
        statement.execute(createTableMovies);

        statement.execute("INSERT INTO `test`.`movies` (`title`, `duration`) VALUES ('Вызов', '2:44:00');");
        statement.execute("INSERT INTO `test`.`movies` (`title`, `duration`) VALUES ('Джон Уик 4', '2:49:00');");
        statement.execute("INSERT INTO `test`.`movies` (`title`, `duration`) VALUES ('Возрождение', '1:37:00');");
    }

    public static void start() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "6830");
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "312808895");
        statement = connection.createStatement();
    }

    public static void stop() throws SQLException {
        statement.close();
        connection.close();
    }

}
