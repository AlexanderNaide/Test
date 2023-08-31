package com.gb.test1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test3 {
    public static void main(String[] args) {
        LocalDateTime cur = LocalDateTime.now();
        System.out.println(cur.getDayOfWeek() + " " + cur.getDayOfMonth() + "/" + cur.getMonth());
        int delta = 5;
        LocalDateTime newDate = cur.plusDays(delta * 7L);
        System.out.println(newDate.getDayOfWeek() + " " + newDate.getDayOfMonth() + "/" + newDate.getMonth());
        LocalDateTime firstDay = newDate.minusDays(newDate.getDayOfWeek().getValue() - 1);
        LocalDateTime secondDay = newDate.plusDays(7 - newDate.getDayOfWeek().getValue());
        System.out.println(firstDay.getDayOfWeek() + " " + firstDay.getDayOfMonth() + "/" + firstDay.getMonth());
        System.out.println(secondDay.getDayOfWeek() + " " + secondDay.getDayOfMonth() + "/" + secondDay.getMonth());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM");
        String period = df.format(firstDay) + " - " + df.format(secondDay);

        System.out.println();
        System.out.println(period);


    }

    public static void test(){

    }
}
