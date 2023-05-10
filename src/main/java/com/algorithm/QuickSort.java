package com.algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {
    public static void main(String[] args) {

        int[] arrNonSort = new int[]{1, 7, 1, 2, 4, 8, 6, 1, 3, 10};
        System.out.println(Arrays.toString(arrNonSort));
//        int[] arrSort = quickSort(arrNonSort);
        int[] arrSort = minQuickSort(arrNonSort);
        System.out.println(Arrays.toString(arrSort));

        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            int a = (int) (Math.random() * 1000000);
            arr[i] = a;
        }
//        System.out.println(Arrays.toString(arr));
        long start1 = System.currentTimeMillis();
        int[] arrResult1 = quickSort(arr);
//        System.out.println(Arrays.toString(arrResult1));
        long time1 = System.currentTimeMillis() - start1;
        System.out.println("Время сортировки Стримами заняло " + time1 + " миллисекунд или " + time1 / 1000 + " секунд.");
        long start2 = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("Время классической сортировки заняло " + time2 + " миллисекунд или " + time2 / 1000 + " секунд.");


    }

    public static int[] quickSort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            int pivot = array[array.length / 2];
            return IntStream.concat(IntStream.concat(Arrays.stream(quickSort(Arrays.stream(array).filter(k -> k < pivot).toArray())), Arrays.stream(array).filter(e -> e == pivot)), Arrays.stream(quickSort(Arrays.stream(array).filter(k -> k > pivot).toArray()))).toArray();
        }
    }

    public static int[] minQuickSort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
//            return IntStream.concat(IntStream.concat(Arrays.stream(minQuickSort(Arrays.stream(array).filter(e -> e < array[array.length / 2]).toArray())), IntStream.of(array[array.length / 2])), Arrays.stream(minQuickSort(Arrays.stream(array).filter(e -> e > array[array.length / 2]).toArray()))).toArray();
            return IntStream.concat(IntStream.concat(Arrays.stream(minQuickSort(Arrays.stream(array).filter(e -> e < array[array.length / 2]).toArray())), Arrays.stream(array).filter(e -> e == array[array.length / 2])), Arrays.stream(minQuickSort(Arrays.stream(array).filter(e -> e > array[array.length / 2]).toArray()))).toArray();
        }
    }

    public static void classicQuickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            classicQuickSort(array, leftPosition, endPosition);
        }
        if (rightPosition > startPosition) {
            classicQuickSort(array, startPosition, rightPosition);
        }
    }

    public static void sort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if (rightPosition > startPosition) {
            sort(array, startPosition, rightPosition);
        }
    }
}
