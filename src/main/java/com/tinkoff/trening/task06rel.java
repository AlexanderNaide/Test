package com.tinkoff.trening;

import java.util.ArrayList;
import java.util.Scanner;

public class task06rel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        int a = -1;
        int b = -1;

        if (!checkingOrder(arr)){
            boolean f = false;
            for (int i = 0; i < arr.size() && !f; i++) {
                ArrayList<Integer> arrD = new ArrayList<>(arr);
                int x = arr.get(i);
                int y;
                for (int j = i + 1; j < arr.size(); j++) {
                    y = arr.get(j);
                    arrD.set(i, y);
                    arrD.set(j, x);
                    if (checkingOrder(arrD)){
                        a = i + 1;
                        b = j + 1;
                        f = true;
                        break;
                    } else {
                        arrD = new ArrayList<>(arr);
                    }
                }
            }
        }
        System.out.println(a + "  " + b);
    }

    public static boolean checkingOrder(ArrayList<Integer> arr){
        for (int i = 1; i <= arr.size(); i++) {
            if(!rest(i) && rest(arr.get(i - 1))){
                return false;
            }
        }
        return true;
    }

    public static boolean rest (int x){
        return (x % 2) == 0;
    }
}