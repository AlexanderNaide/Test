package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Во время разработки некоторой задачи Саша решил сгенерировать несколько новых тестов.
 * Каждый тест Саши должен представлять собой натуральное число, не меньшее l и не большее r.
 * Кроме того, натуральное число в тесте обязательно должно состоять из одинаковых цифр.
 * Например, число 999 подходит под это требование, а число 123 — нет.
 * Какое максимальное число различных тестов сможет создать Саша?
 *
 * Формат входных данных:
 * В единственной строке вводятся два натуральных числа l,r (1?l,r?10^18)— ограничения на тесты Саши.
 * Обратите внимания, что эти числа не вместятся в 32-битный тип данных, используйте 64-битный при необходимости
 *
 * Формат выходных данных:
 * Выведите одно число — количество тестов, которое может сделать Саша.
 *
 * Замечание:
 * В первом тесте Саше подходят номера [4,5,6,7].
 * Во втором тесте подходят все числа, кратные 11, от 11 до 99.
 *
 * Примеры данных:
 * Пример 1:
 * Ввод: 4  7
 * Вывод: 4
 * Пример 2:
 * Ввод: 10  100
 * Вывод: 9
 *
 * ------------- ОК -------------
 *
 */

public class task05 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        long startMem = Runtime.getRuntime().freeMemory();
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        scanner.close();
        long a = getStart(l);
        System.out.println("l / a = " + l + " / " + a);


        if (a > 1){
            long b = a;
            while (b < l) {
                b += a;
            }
            l = b;
        }

        int count = 0;
        for (long i = l; i <= r;) {
            System.out.println(i);
            count++;
            if(digit(i + 1) > digit(i)){
                i = getStart(i + 1);
            } else {
                i += getStart(i);
            }
        }
        System.out.println(count);
        System.out.println("Время, сек: " + (System.currentTimeMillis() - startTime)/1000);
        System.out.println("Память, mB : " + (startMem - Runtime.getRuntime().freeMemory()) / (8 * 1024));
    }

    public static Long getStart(long x){
        long[] dd = new long[digit(x)];
        Arrays.fill(dd, 1);
        stringBuilder.setLength(0);
        for (long l : dd) {
            stringBuilder.append(l);
        }
        return Long.parseLong(String.valueOf(stringBuilder));
    }

    public static Integer digit(long x){
        int a = 0;
        while (x > 0){
            a++;
            x = x / 10;
        }
        return a;
    }
}
