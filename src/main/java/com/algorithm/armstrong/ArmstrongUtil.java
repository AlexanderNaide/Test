package com.algorithm.armstrong;

public class ArmstrongUtil {

    public static final int[][] MATRIX = new int[10][11];
    
    static {
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                MATRIX[i][j] = (int) Math.pow(i, j);
            }
        }
    }

    public static int[] split(int value, int length){
        int[] result = new int[length];
        int currentValue = value;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = currentValue % 10;
            currentValue /= 10;
        }
        return result;
    }

    public static int length (int value){
        int l = 10;
        int max = 1_000_000_000;
        while (value < max){
            l--;
            max /= 10;
        }
        return l;
    }

}
