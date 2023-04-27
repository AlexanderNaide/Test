package com.gb.interview.homework4_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class reviewDB {

    private static Connection connection;
    private static Statement statement;



    public static void main(String[] args) throws SQLException {

        try {
            start();

            SELECT * FROM test.movies;

            select m.title, s.date_time, m.duration from movies as m
            join test.schedule as s
            on s.movie_id = m.id
            where s.sinema_hall = 1;

            select m.title, s.date_time, m.duration, (s.date_time + m.duration) as finish from movies as m
            join test.schedule as s
            on s.movie_id = m.id
            where s.sinema_hall = 1
            and (s.date_time + m.duration) > s.date_time + 1
            order by finish;

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

            String createTableSchedule = "CREATE TABLE IF NOT EXISTS `test`.`schedule` (\n" +
                    "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                    "  `movie_id` BIGINT UNSIGNED NOT NULL,\n" +
                    "  `date_time` DATETIME NULL,\n" +
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

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            stop();
        }
    }

    public static void start() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "6830");
        statement = connection.createStatement();
    }

    public static void stop() throws SQLException {
        statement.close();
        connection.close();
    }

}
