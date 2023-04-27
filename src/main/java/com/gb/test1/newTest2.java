package com.gb.test1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class newTest2 {
    public static void main(String[] args) {
        int m = 25;
        int p = 2;
        int d = 3;
        int n;

        n = (m + (p - 1) * d) % 26;


        System.out.println(n);

        System.out.println(n == (m + (p - 1) * d));
        System.out.println((m + (p - 1) * d));

    }


}
