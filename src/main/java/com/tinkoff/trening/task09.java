package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Даня в обеденный перерыв ходит в одно и то же кафе. Ему, как сотруднику банка, положено специальное предложение:
 * при каждой покупке больше, чем на 100 рублей, Даня получает купон на бесплатный обед.
 * Даня узнал стоимость своих обедов на ближайшие n дней. Ему хочется минимизировать свои затраты,
 * грамотно используя талоны. Требуется найти минимальные суммарные затраты Дани на обеды.
 * Формат входных данных:
 * В первой строке дается натуральное число n(0≤n≤100).
 * В каждой из n строк записана стоимость обеда в каждой из дней
 * (неотрицательное целое число, не больше, чем 300).
 * Формат выходных данных:
 * В первой строке выдайте минимально возможную суммарную стоимость обедов.
 * Замечание:
 * В первом примере Дане придется купить первые 3 обеда, после чего у него появится талон.
 * Этот талон будет выгоднее всего потратить на последний обед. Таким образом, он купит первые
 * 4 обеда и получит пятый бесплатный.
 * Примеры данных:
 * Пример 1
 * Ввод:
 * 5
 * 35
 * 40
 * 101
 * 59
 * 63
 * Вывод:
 * 235
 * ------------- ?? -------------
 */

public class task09 {
    static HashMap<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(n);
        System.out.println(Arrays.toString(arr));
        ddd(arr, 0, false);
//        int coupon = 0;
//        for (int i : arr) {
//            if(i >= 100){
//                coupon++;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//
//        }



        map.forEach((key, value) -> System.out.println(key + " - " + Arrays.toString(value)));

//        System.out.println(Arrays.stream(arr).sum());
    }

    public static void ddd(int[] arr, int start, boolean flag){
        System.out.println("Пришел " + Arrays.toString(arr) + " считаем от " + start);
        int max = 0;
        int position = -1;
//        boolean flag = false;
        boolean req = false;
        for (int i = start; i < arr.length; i++) {
            System.out.println("проверяем " + arr[i]);
            if(arr[i] >= 100){
                flag = true;

                System.out.println("Установили флаг на " + arr[i]);
                if(i < arr.length - 1 && !req){
                    System.out.println("переслали");
                    if(!flag){
                        ddd(Arrays.copyOf(arr, arr.length), i + 1, true);
                    } else {
                        ddd(arr, i + 1, true);
                    }
                    req = true;
                    flag = false;
                }
            }

//            if(arr[i] >= 100 && i < arr.length - 1 && flag){
//                System.out.println("переслали");
//                ddd(Arrays.copyOf(arr, arr.length), i + 1);
//            }

            if (arr[i] > max && flag){
                System.out.println("установили max");
                max = arr[i];
                position = i;
            }
        }

        if (position != -1){
            System.out.println("В итоге max - " + arr[position]);
            arr[position] = 0;
        }
//        map.put(Arrays.stream(arr).sum(), Arrays.copyOf(arr, arr.length));
        System.out.println("там где " + start + " получаем " + Arrays.toString(arr)) ;
        map.put(Arrays.stream(arr).sum(), arr);
    }
}
