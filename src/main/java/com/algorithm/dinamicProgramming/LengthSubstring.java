package com.algorithm.dinamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LengthSubstring {
    public static void main(String[] args) {


        String one = "vista";
        String two = "fish";



//        int[] grid = getLength(one, two);
        int max = getLength(one, two);




        System.out.println("---------------");
        System.out.println(max);
//        Arrays.stream(grid).forEach(System.out::println);


    }

    private static int getLength(String one, String two) {

        int[] grid = new int[one.length()];
        Arrays.fill(grid, 0);
        char[] header = one.toCharArray();
        char[] body = two.toCharArray();
        int max = 0;

        for (char c : body) {
            grid = getRow(header, grid, c);
            for (int i : grid) {
                if (i > max){
                    max = i;
                }
            }
        }

        return max;
    }

    private static int[] getRow(char[] header, int[] row, char x){
        int[] resultRow = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            System.out.println("сравниваем " + x + " и " + header[i]);
            if (i != 0) {
                resultRow[i] = header[i] == x ? row[i - 1] + 1 : 0;
            } else {
                resultRow[i] = header[i] == x ? 1 : 0;
            }
            System.out.println("стало " + resultRow[i]);
        }
        return resultRow;
    }
}
