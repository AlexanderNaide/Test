package com.gb.test1;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.*;

public class Test2 {

    public static void main(String [] args){
        LocalDateTime current = LocalDateTime.now();
        System.out.println(current.get(ChronoField.YEAR));
        System.out.println(current.get(ChronoField.YEAR) + "" + current.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println("----------");
        String t = "2023-08-01 18:00:00.0";
        LocalDateTime time = LocalDateTime.parse(t,  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        System.out.println(DateTimeFormatter.ofPattern("HH:mm").format(time));
    }
}