package com.tinkoff.trening;

import java.util.ArrayList;
import java.util.Scanner;

public class task06newRel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> var = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            if (a % 2 != (i + 1) % 2){
                var.add(i + 1);
            }
        }
        scanner.close();

        if (var.size() == 2){
            System.out.println(var.get(0) + "  " + var.get(1));
        } else {
            System.out.println("-1  -1");
        }
    }
}
