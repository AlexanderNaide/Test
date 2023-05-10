package com.tinkoff.trening;

import java.util.*;

public class task06newRel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> dev = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedArr[i] || sortedArr[i] % 2 != (i + 1) % 2) {
                dev.add(i + 1);
            }
        }
        if (dev.size() == 2) {
            System.out.println(dev.get(0) + "  " + dev.get(1));
        } else {
            System.out.println("-1 -1");
        }
    }
}