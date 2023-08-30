package com.algorithm.newTraning;

import java.util.ArrayList;
import java.util.List;


// Пузырьковая сортировка
public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 7, 6, 2, 8, 1, 4, 5, 0, 9));

        bubbleSort(list);

        System.out.println(list);
    }

    public static void bubbleSort(ArrayList<Integer> list){
/*        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - (1 + i); j++) {
                if (list.get(j + 1) < list.get(j)){
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }*/

        for (int i = list.size() - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
//                System.out.println(i + "/" + j);
                if (list.get(j + 1) < list.get(j)){
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }

        }




    }
}
