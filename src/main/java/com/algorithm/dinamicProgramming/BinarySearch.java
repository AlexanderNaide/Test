package com.algorithm.dinamicProgramming;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 4));

    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int position;
        int positionValue;
        while (left <= right) {
            position = (left + right) / 2;
            positionValue = arr[position];
            if (positionValue == value) {
                return position;
            } else if (positionValue < value) {
                left = position + 1;
            } else {
                right = position - 1;
            }
        }
        return -1;
    }
}
