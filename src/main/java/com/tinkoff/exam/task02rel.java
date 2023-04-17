package com.tinkoff.exam;

import java.util.Scanner;

public class task02rel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        int m;
        int k;

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        scanner.close();

        int checkAll = n * k;
        int min = checkAll % m == 0 ? checkAll / m : checkAll / m + 1;

        System.out.println(min);

    }
}
