package com.algorithm.armstrong;

public class ArrayAlgorithm {

    private final Logger logger = new Logger();

    public void calculate(int max) {

        int maxLength = ArmstrongUtil.length(max);
        int[] array = new int[maxLength];
        do {
            for (int i = length(array); i <= maxLength ; i++) {
                int result = algorithm(array, i);
                if (result > 0) {
                    int resultLength = ArmstrongUtil.length(result);
                    int checkResult = algorithm(ArmstrongUtil.split(result, resultLength), resultLength);
                    if (checkResult == result) {
                        logger.log(checkResult);
                    }
                }
            }

        } while ((array = increment(array, array.length - 1)) != null);
        logger.print();
    }

    private int algorithm(int[] array, int length){
        int result = 0;
        for (int i = 0; i < length; i++) {
            int temp = result + ArmstrongUtil.MATRIX[array[array.length - 1 - i]][length];
            if (result > temp){
                return -1;
            } else {
                result = temp;
            }
        }
        return result;
    }

    private int length(int[] array) {
        int length = array.length;
        for (int j : array) {
            if (j == 0) {
                length--;
            } else {
                break;
            }
        }
        if (length == 0) {
            return 1;
        } else {
            return length;
        }
    }

    private int[] increment(int[] array, int index) {
        int value = array[index];
        if (value < 9) {
            array[index] = value + 1;
            return array;
        } else {
            if (index > 0) {
                int[] result = increment(array, index - 1);
                if (result != null) {
                    result[index] = result[index - 1];
                }
                return result;
            } else {
                return null;
            }
        }
    }

}
