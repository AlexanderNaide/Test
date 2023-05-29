package com.yandex.study.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\F"));
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        Map<String, Map<String, Long>> history = new TreeMap<>();
        while (reader.ready()){
            String line = reader.readLine();
            String[] s = line.split(" ");
            if (!history.containsKey(s[0])){
                Map<String, Long> currentMap = new TreeMap<>();
                currentMap.put(s[1], (long) Integer.parseInt(s[2]));
                history.put(s[0], currentMap);
            } else {
                if (!history.get(s[0]).containsKey(s[1])){
                    history.get(s[0]).put(s[1], (long) Integer.parseInt(s[2]));
                } else {
                    history.get(s[0]).replace(s[1], history.get(s[0]).get(s[1]) + (long) Integer.parseInt(s[2]));
                }
            }
        }
        reader.close();

        for (Map.Entry<String, Map<String, Long>> mapEntry : history.entrySet()) {
            System.out.println(mapEntry.getKey() + ":");
            for (Map.Entry<String, Long> longEntry : mapEntry.getValue().entrySet()) {
                System.out.println(longEntry.getKey() + " " + longEntry.getValue());
            }
        }

        Long step1 = System.currentTimeMillis();
        System.out.println(step1 - start);




        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\F"));
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        Map<String, Map<String, Long>> history2 = new TreeMap<>();
        while (reader2.ready()){
            String line = reader2.readLine();
            String[] s = line.split(" ");
            if (!history2.containsKey(s[0])){
                Map<String, Long> currentMap = new TreeMap<>();
                currentMap.put(s[1], (long) Integer.parseInt(s[2]));
                history2.put(s[0], currentMap);
            } else {
                if (!history2.get(s[0]).containsKey(s[1])){
                    history2.get(s[0]).put(s[1], (long) Integer.parseInt(s[2]));
                } else {
                    history2.get(s[0]).replace(s[1], history2.get(s[0]).get(s[1]) + (long) Integer.parseInt(s[2]));
                }
            }
        }
        reader2.close();

        for (Map.Entry<String, Map<String, Long>> mapEntry : history2.entrySet()) {
            System.out.println(mapEntry.getKey() + ":");
            for (Map.Entry<String, Long> longEntry : mapEntry.getValue().entrySet()) {
                System.out.println(longEntry.getKey() + " " + longEntry.getValue());
            }
        }




        Long step2 = System.currentTimeMillis();
        System.out.println(step2 - step1);
    }
}