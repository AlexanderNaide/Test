package com.yandex.study.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\C"));
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int max = 0;

        while (reader.ready()){
            String line = reader.readLine();
            for (String s : line.split(" ")) {
                if (result.equals("")){
                    result = s;
                }
                if (!map.containsKey(s)){
                    map.put(s, 1);
                } else {
                    map.replace(s, map.get(s) + 1);
                }
                int count = map.get(s);
                if (count > max){
                    max = count;
                    result = s;
                } else if (count == max){
                    if (result.compareTo(s) > 0){
                        result = s;
                    }
                }
            }
        }

        reader.close();

        System.out.println(result);
    }
}