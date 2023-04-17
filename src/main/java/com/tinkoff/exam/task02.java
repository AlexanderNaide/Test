package com.tinkoff.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class task02 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));

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
