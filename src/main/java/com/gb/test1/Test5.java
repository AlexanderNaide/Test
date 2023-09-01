package com.gb.test1;

public class Test5 {
    public static void main(String[] args) {
        String msg = "Hello";
        change(msg);
        System.out.print(msg);
        msg = change(msg);
        System.out.print(msg);
    }

    public static String change(String msg){
        msg = msg + " world!";
        return " java!";
    }
}
