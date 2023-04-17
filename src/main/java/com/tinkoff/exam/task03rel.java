package com.tinkoff.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task03rel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String l = scanner.nextLine().substring(0, n);

        scanner.close();

        ArrayList<Integer> variants = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            String sample;
            for (int j = i + 4; j < n + 1; j++) {
                sample = l.substring(i, j);
                if (sample.contains("a") && sample.contains("b") && sample.contains("c") && sample.contains("d")) {
                    variants.add(sample.length());
                    break;
                }
            }
        }

        if (variants.size() > 0) {
            System.out.println(Collections.min(variants));
        } else {
            System.out.println(-1);
        }
    }
}
