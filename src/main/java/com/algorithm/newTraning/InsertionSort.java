package com.algorithm.newTraning;

import java.util.ArrayList;
import java.util.List;


// Сортировка вставкой
public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 7, 6, 2, 8, 1, 4, 5, 0, 9));

        insertionSort(list);

        System.out.println(list);
    }

    public static void insertionSort(ArrayList<Integer> list){

        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i;
            while(j > 0 && list.get(j - 1) >= temp){
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, temp);
//            System.out.println(list);
        }

    }
}
