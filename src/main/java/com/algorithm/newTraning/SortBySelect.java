package com.algorithm.newTraning;

import java.util.ArrayList;
import java.util.List;


// Сортировка выбором
public class SortBySelect {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 7, 6, 2, 8, 1, 4, 5, 0, 9));

        sortBySelect(list);

        System.out.println(list);
    }

    public static void sortBySelect(ArrayList<Integer> list){

        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i; j < list.size() - 1; j++) {
                if (list.get(j) < list.get(min)){
                    min = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
    }
}
