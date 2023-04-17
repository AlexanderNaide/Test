package com.tinkoff.trening;

import java.util.Scanner;

public class task01rel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        scanner.close();

        int sum;
        if (d < b){
            sum = a;
        } else {
            sum = ((d - b) * c) + a;
        }

        System.out.println(sum);
    }
}
