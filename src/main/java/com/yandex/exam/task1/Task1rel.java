package com.yandex.exam.task1;

import java.io.*;
import java.util.*;

public class Task1rel {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("input.txt"));

        int n = scanner.nextInt();
        int[] keys = new int[n];
        int[] values = new int[n];

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            keys[i] = scanner.nextInt();
        }
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            map.put(keys[i], values[i]);
        }
        int k = scanner.nextInt();
        int[] text = new int[k];
        for (int i = 0; i < text.length; i++) {
            text[i] = scanner.nextInt();
        }
        scanner.close();

        int count = 0;
        int str = 0;
        for (int i : text) {
            int currentStr = map.get(i);
            if (str == 0){
                str = currentStr;
            } else if (str != currentStr) {
                count++;
                str = currentStr;
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(String.valueOf(count));
        writer.flush();
        writer.close();

    }
}
