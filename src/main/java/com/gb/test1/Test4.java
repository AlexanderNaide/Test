package com.gb.test1;

import java.io.IOException;

public class Test4 extends Test3 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr.length);

        String s = "String s = " + 2 + 2;
        System.out.println(s);

        String str = "Java";
        System.out.println(str.charAt(2));
        String str2 = str.toUpperCase();
        System.out.println(str);
        System.out.println(str2);

        byte a = 127;
        a++;
        System.out.println(a);

        char f = 'f';
        switch (f) {
            case 'f' -> System.out.println("!!!");
            case 'a' -> System.out.println("!4!");
            default -> System.out.println("&&&");
        }

        String s1 = (2+2) + " = Java";
        System.out.println(s1);

        int[] f44[] = new int[5][5];
//        System.out.println(val());

        int[] a2 = new int[10];
        a2[20] = 10;
        a2[5] = a2[2] / 2;



    }
    static int a;
    public int d;

    public boolean val(){

        class Team{
            int a;
            int b;
        }

        return 'a' < 70;
    }

    public static class Bear {
    }
}
