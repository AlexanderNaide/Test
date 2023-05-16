package com.yandex.study.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\B"));
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder buf = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while (reader.ready()){
            int i = reader.read();
            if (i != 32 && i != 13 && i != 10){
                buf.append((char) i);
            } else if (buf.length() != 0) {
                String s = buf.toString();
                buf.setLength(0);
                if (map.containsKey(s)){
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 0);
                }
                result.append(map.get(s)).append(" ");
            }
        }
        if (buf.length() != 0) {
            String s = buf.toString();
            buf.setLength(0);
            if (map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 0);
            }
            result.append(map.get(s)).append(" ");
        }
        reader.close();

        System.out.println(result);
    }
}