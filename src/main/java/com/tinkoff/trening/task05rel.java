package com.tinkoff.trening;

import java.util.Arrays;
import java.util.Scanner;

public class task05rel {
    private static final StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        scanner.close();
        long a = getStart(l);
        if (a > 1){
            long b = a;
            while (b < l) {
                b += a;
            }
            l = b;
        }
        int count = 0;
        for (long i = l; i <= r;) {
            count++;
            if(digit(i + 1) > digit(i)){
                i = getStart(i + 1);
            } else {
                i += getStart(i);
            }
        }
        System.out.println(count);
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
