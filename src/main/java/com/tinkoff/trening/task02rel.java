package com.tinkoff.trening;

import java.util.Scanner;

public class task02rel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(calc(n));
        scanner.close();
    }

    public static int calc(int n) {
        if (n < 2) {
            return 0;
        } else if (n < 4) {
            return n - 1;
        } else {
            return 1 + calc((n / 2) + (n % 2));
        }
    }
}
