package com.algorithm;

import java.util.Arrays;

public class ExamplesCode {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(arr, 5));


        int[] arrNonSort = new int[]{5, 7, 9, 2, 4, 8, 6, 1, 3, 10};
        System.out.println(Arrays.toString(arrNonSort));
        quickSort(arrNonSort, 0, arrNonSort.length - 1);
        System.out.println(Arrays.toString(arrNonSort));

        int[] arrNonSort2 = new int[]{5, 7, 9, 2, 4, 8, 6, 1, 3, 10, 0};

    }

    // простая сортировка из книги



// тренировка Бинарного поиска
    public static int search(int[] arr, int value){
        int left = 0;
        int right = arr.length - 1;
        int position, positionValue;
        while(left <= right){
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

    // тренировка Быстрой сортировки
    public static void quickSort(int[] arr, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = arr[(startPosition + endPosition) / 2];
        do{
            while (arr[leftPosition] < pivot){
                leftPosition++;
            }
            while (arr[rightPosition] > pivot){
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
        } while(leftPosition <= rightPosition);
        if(leftPosition < endPosition){
            quickSort(arr, leftPosition, endPosition);
        }
        if(rightPosition > startPosition){
            quickSort(arr, startPosition, rightPosition);
        }
    }

}
