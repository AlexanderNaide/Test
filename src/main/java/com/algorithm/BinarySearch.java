package com.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        System.out.println(search(array, 1));
    }

    public static int search(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int position, positionValue;
        while (left <= right) {
            position = (left + right) / 2;
            positionValue = array[position];
            if (positionValue == value){
                return position;
            }
            if (positionValue > value){
                right = position - 1;
            } else  {
                left = position + 1;
            }
        }
        return -1;
    }
}
