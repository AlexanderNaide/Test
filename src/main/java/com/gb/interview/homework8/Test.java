package com.gb.interview.homework8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

//        int[] arr = {-5, -3, 0, 1, 2, 6};
//        int[] arr = {-11, -6, -3, -1};
        int[] arr = {Integer.MIN_VALUE, -10, -8, -6, -3, -1};
//        int[] arr = {3, 6, 12, 18};

        long[] res = method1(arr);

        System.out.println(Arrays.toString(res));

    }

    private static long[] method1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        long[] result = new long[arr.length];
        int i = arr.length - 1;
        while (left <= right){
            long a = (long) Math.pow(arr[left], 2);
            long b = (long) Math.pow(arr[right], 2);
            if(a > b){
                result[i] = a;
                i--;
                left++;
            } else {
                result[i] = b;
                i--;
                right--;
            }
        }
        return result;

    }
}
