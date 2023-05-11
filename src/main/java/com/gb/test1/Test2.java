package com.gb.test1;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
//        initial();

//        ArrayList<Integer> a = new ArrayList<>(10);
//        Set<Integer> a = new HashSet<>(10);
        Map <Integer, Integer> a = new HashMap<>();
//        Collections.fill(a, 0);
        a.put(1, 1);
        a.put(2, 3);
        a.put(3, 1);
        System.out.println(a);
        System.out.println(a);
    }

    private static void initial() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            int x;
            if (i == 99999){
                x = 1;
            } else {
                x = i + 2;
            }

            if (i == 0){
                sb.append(x);
            } else {
                sb.append("  ").append(x);
            }

        }
        System.out.println(sb);
    }
}
