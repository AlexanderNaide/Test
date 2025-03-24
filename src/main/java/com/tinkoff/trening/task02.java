package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать рулет
 * на N равных частей. Разумеется, рулет можно резать только поперек. Соотвественно,
 * Костя сделает N?1 разрез ножом через равные промежутки.
 * По возвращению с кофе-брейка Ваня задумался — а можно ли было обойтись меньшим числом движений,
 * будь нож Вани бесконечно длинным (иначе говоря, если он мог бы сделать сколько угодно разрезов
 * за раз, если эти разрезы лежат на одной прямой)? Считается, что места для разрезов намечены
 * заранее, и все разрезы делаются с ювелирной точностью.
 * Оказывается, что можно. Например, если Ваня хотел бы разделить рулет на 4 части,
 * он мог бы обойтись двумя разрезами — сначала он разделил бы рулет на две половинки,
 * а потом совместил бы две половинки и разрезал обе пополам одновременно.
 * Вам дано число N, требуется сказать, каким минимальным числом разрезов можно обойтись.
 * Формат входных данных:
 * Дано одно натуральное число
 * N(1?N?2?10^9) — количество людей на кофе-брйке.
 * Формат выходных данных:
 * Выведите одно число — минимальное число движений, которое придется сделать Косте.
 * Замечание:
 * Чтобы разрезать рулет на 6 частей, Ване сначала придется разрезать его на две
 * равные части, после чего совместить две половинки и сделать два разреза.
 * Чтобы разрезать рулет на 5 частей, Ване понадобится разделить его в соотношении
 * 2:3, после чего совместить два рулета по левому краю и разрезать бОльший рулет
 * на одинарные кусочки — меньший тоже разделится на одинарные.
 * Примеры данных:
 * Ввод 6
 * Вывод 3
 * Ввод 5
 * Вывод 3
 *
 */

public class task02 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));

        int n;
        int count;
        while(scanner.hasNext()){
            n = scanner.nextInt();
            count = calc(n);
            System.out.println(n + " - " + count);
        }
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
