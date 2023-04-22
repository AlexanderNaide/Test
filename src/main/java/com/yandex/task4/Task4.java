package com.yandex.task4;

import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws IOException {


//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        int[] incomeRequest = new int[n];
        for (int i = 0; i < n; i++) {
            incomeRequest[i] = scanner.nextInt();
        }
        int[] educationRequest = new int[n];
        for (int i = 0; i < n; i++) {
            educationRequest[i] = scanner.nextInt();
        }
        int[] childRequest = new int[n];
        for (int i = 0; i < n; i++) {
            childRequest[i] = scanner.nextInt();
        }
        int schoolmate = scanner.nextInt();
        int[] income = new int[schoolmate];
        for (int i = 0; i < schoolmate; i++) {
            income[i] = scanner.nextInt();
        }
        int[] education = new int[schoolmate];
        for (int i = 0; i < schoolmate; i++) {
            education[i] = scanner.nextInt();
        }
        int[] child = new int[schoolmate];
        for (int i = 0; i < schoolmate; i++) {
            child[i] = scanner.nextInt();
        }

        scanner.close();

        int[] result = new int[schoolmate];
        Arrays.fill(result, 0);
        boolean x = false;
        boolean y = false;
        for (int i = 0; i < schoolmate; i++) {
            int inc = income[i];
            int ed = education[i];
            int ch = child[i];
            for (int j = 0; j < n; j++) {
                x = (incomeRequest[j] <= inc && educationRequest[j] <= ed);
                y = (childRequest[j] == 1 && !x && ch == j + 1);
                if ((x || y) && result[i] == 0) {
                    result[i] = j + 1;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (i != 0){
                System.out.print(" ");
            }
            System.out.print(result[i]);
        }

    }

}
