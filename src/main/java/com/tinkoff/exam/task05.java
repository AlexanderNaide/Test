package com.tinkoff.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class task05 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));


        /**
         * Два ряда чисел.
         * В первом число n - количество чисел в последовательности
         * Во втором - последовательность.
         *
         *
         */


        int n = scanner.nextInt();
//        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        scanner.close();

        int count = searchNull(list);

        System.out.println(count);


    }

    public static int searchNull(List<Integer> list){
        int n = list.size();
        int count = 0;

        for (int i = n; i > 1; i--) {
            for (int j = 0; j <= n - i; j++) {
                List<Integer> subList = list.subList(j, i);
                if (subList.size() > 2 && (j > 0 || i < n)){
                    searchNull(subList);
                } else {
                    if (inNull(subList)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static boolean inNull(List<Integer> list){
        int summ = 0;
        for (Integer integer : list) {
            summ += integer;
        }
        return summ == 0;
    }
}
