package com.gb.test1;

public class Test2 {
    public static void main(String[] args) {
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
