package com.algorithm.newTraning;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 9, 1, 3, 5, 8, 0, 4, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = arr[(startPosition + endPosition) / 2];
        do {
            while(arr[leftPosition] < pivot){
                leftPosition++;
            }
            while(arr[rightPosition] > pivot){
                rightPosition--;
            }
            if(leftPosition <= rightPosition){
                if(leftPosition < rightPosition){
                    int temp = arr[leftPosition];
                    arr[leftPosition] = arr[rightPosition];
                    arr[rightPosition] = temp;
                }

                leftPosition++;
                rightPosition--;
            }

            if (leftPosition < rightPosition){
                quickSort(arr, leftPosition, endPosition);
            }
            if (rightPosition > startPosition){
                quickSort(arr, startPosition, rightPosition);
            }
        } while (leftPosition <= rightPosition);
    }


}
