package com.yandex.study.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ftemp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\F"));
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, Map<String, Integer>> history = new HashMap<>();
        while (reader.ready()){
            String line = reader.readLine();
            String[] s = line.split(" ");
            int one = line.indexOf(" ");
            String name = line.substring(0, one);
//            System.out.println(name);
            int two = line.indexOf(" ", one + 1);
//            System.out.println(two);
            String product = line.substring(one, two);
            int price = Integer.parseInt(line.substring(two + 1));

            System.out.println(name + " - " + product + " - " + price);

            if (!history.containsKey(s[0])){
                Map<String, Integer> currentMap = new HashMap<>();
                currentMap.put(s[1], Integer.parseInt(s[2]));
                history.put(s[0], currentMap);
            } else {
                if (!history.get(s[0]).containsKey(s[1])){
                    history.get(s[0]).put(s[1], Integer.parseInt(s[2]));
                } else {
                    history.get(s[0]).replace(s[1], history.get(s[0]).get(s[1]) + Integer.parseInt(s[2]));
                }
            }
        }
        ArrayList<String> names = new ArrayList<>(history.keySet());
        names.sort(String::compareTo);
        for (String name : names) {
            System.out.println(name + ":");
            ArrayList<String> products = new ArrayList<>(history.get(name).keySet());
            products.sort(String::compareTo);
            for (String product : products) {
                System.out.println(product + " " + history.get(name).get(product));
            }
        }
    }
}