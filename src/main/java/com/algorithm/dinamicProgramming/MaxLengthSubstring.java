package com.algorithm.dinamicProgramming;

import java.util.Arrays;

public class MaxLengthSubstring {
    public static void main(String[] args) {


        String one = "fosh";
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

        for (char c : body) {
            grid = getRow(header, grid, c);
        }

        return grid[grid.length - 1];
    }

    private static int[] getRow(char[] header, int[] row, char x){
        int[] resultRow = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            System.out.println("сравниваем " + x + " и " + header[i]);
            if (i != 0) {
                resultRow[i] = header[i] == x ? row[i - 1] + 1 : Math.max(resultRow[i - 1], row[i]);
            } else {
                resultRow[i] = header[i] == x ? 1 : row[i];
            }
            System.out.println("стало " + resultRow[i]);
        }
        return resultRow;
    }
}
