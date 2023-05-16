package com.yandex.exam.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Task2rel {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        String[] str1 = reader.readLine().split(" ");
        String[] str2 = reader.readLine().split(" ");

        int n = Integer.parseInt(str1[0]);
        int x = Integer.parseInt(str1[1]);
        long t = Long.parseLong(str1[2]);

        ArrayList<Sculpture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Sculpture sc = new Sculpture();
            sc.position = i + 1;
            sc.weight = Integer.parseInt(str2[i]);
            sc.difference = Math.abs(x - sc.weight);
            list.add(sc);
        }
        reader.close();

        Comparator<Sculpture> comparator = (Sculpture s1, Sculpture s2) -> (int) (s1.difference - s2.difference);

        list.sort(comparator);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Sculpture sculpture : list) {
            long def = sculpture.difference;
            if (def <= t){
                count++;
                t -= def;
                if (sb.length() == 0) {
                    sb.append(sculpture.position);
                } else {
                    sb.append(" ").append(sculpture.position);
                }
            } else {
                break;
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(String.valueOf(count));
        if (count > 0){
            writer.newLine();
            writer.write(sb.toString());
        }
        writer.flush();
        writer.close();

    }

    public static class Sculpture{
        public int position;
        public int weight;
        public long difference;
    }
}