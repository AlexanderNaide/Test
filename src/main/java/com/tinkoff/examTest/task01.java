package com.tinkoff.examTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        scanner.close();

        System.out.println(a + b);

    }
}
