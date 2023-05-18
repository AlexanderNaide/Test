package com.yandex.study.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\E"));
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<Integer, Integer> blocks = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            int width = Integer.parseInt(s[0]);
            int height = Integer.parseInt(s[1]);
            if (blocks.containsKey(width)){
                blocks.replace(width, Math.max(blocks.get(width), height));
            } else {
                blocks.put(width, height);
            }
        }
        reader.close();
        ArrayList<Integer> resultKeys = new ArrayList<>(blocks.keySet());
        resultKeys.sort(Integer::compareTo);
        long result = 0L;
        for (int i = resultKeys.size() - 1; i >= 0 ; i--) {
            result += blocks.get(resultKeys.get(i));
        }
        System.out.println(result);
    }
}