package com.tinkoff.trening;

import java.util.Scanner;

public class task03rel {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int a = scanner.nextInt();
        scanner.close();

        if(n < 3 || a == 1 || a == n){
            System.out.println(arr[arr.length - 1] - arr[0]);
        } else {
            int bottom = 0;
            int top = 0;

            for (int i = 1; i < arr.length; i++) {
                int i2 = arr[i] - arr[i - 1];
                if (i < a){
                    bottom += i2;
                } else {
                    top += i2;
                }
            }

            if (bottom <= t || top <= t){
                System.out.println(bottom + top);
            } else {
                System.out.println(Math.min(bottom, top) * 2 + Math.max(bottom, top));
            }
        }
    }
}
