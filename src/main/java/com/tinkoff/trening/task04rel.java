package com.tinkoff.trening;

import java.util.Scanner;

public class task04rel {
    public static void main(String[] args) {
        int n;
        int t;
        int l;
        long starts;
        long finish;
        int[][] matrix;
        int max;
        int tf;
        int[] fArr;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        starts = 0L;
        l = 0;
        for (int i : arr) {
            starts += i;
            int lv = String.valueOf(i).length();
            l = Math.max(l, lv);
        }

        matrix = new int[n][l];

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            String line = String.valueOf(x);
            for (int j = 0; j < l; j++) {
                int xl;
                if ((l - 1) - j < line.length()) {
                    xl = Integer.parseInt(String.valueOf(line.charAt(j - (l - line.length()))));
                } else {
                    xl = -1;
                }
                matrix[i][j] = xl;
            }
        }

        max = l;

        tf = t;
        while (tf > 0) {
            int a = 9;
            int x = -1;
            int y = -1;
            for (int i = 0; i < n; i++) {
                int b = matrix[i][l - max];
                if (b < a && b != -1) {
                    a = b;
                    x = i;
                    y = l - max;
                }
            }
            if (x != -1) {
                matrix[x][y] = 9;
                tf--;
            } else if (max > 1) {
                max--;
            } else {
                break;
            }
        }

        fArr = new int[n];
        for (int i = 0; i < n; i++) {
            StringBuilder res = new StringBuilder();
            for (int ints : matrix[i]) {
                if (ints != -1) {
                    res.append(ints);
                }
            }
            fArr[i] = Integer.parseInt(res.toString());
        }

        finish = 0L;
        for (int i : fArr) {
            finish += i;
        }

        System.out.println(finish - starts);
    }
}
