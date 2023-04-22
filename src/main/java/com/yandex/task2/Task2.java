package com.yandex.task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(new File("input.txt"));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int t = scanner.nextInt();

        ArrayList<Sculpture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Sculpture sc = new Sculpture();
            sc.position = i + 1;
            sc.weight = scanner.nextInt();
            sc.difference = Math.abs(x - sc.weight);
            list.add(sc);
        }

        scanner.close();

        Comparator<Sculpture> comparator = (Sculpture s1, Sculpture s2) -> s1.difference - s2.difference;

        list.sort(comparator);

        list.forEach(e -> System.out.println(e.position + " - " + e.weight + " - " + e.difference));

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Sculpture sculpture : list) {
            int def = sculpture.difference;
            if (def <= t) {
                count++;
                t -= def;
                if (sb.length() == 0) {
                    sb.append(sculpture.position);
                } else {
                    sb.append(" ").append(sculpture.position);
                }
            } else {
                sb.delete(sb.length() - 1, sb.length());
                break;
            }
        }

        System.out.println(count);

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(String.valueOf(count));
        writer.write("\n");
        writer.write(sb.toString());
        writer.flush();
        writer.close();

    }

    public static class Sculpture {
        public int position;
        public int weight;
        public int difference;
    }
}


