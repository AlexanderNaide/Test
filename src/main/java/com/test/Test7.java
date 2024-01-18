package com.test;


import java.util.Arrays;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 3, 7);
        List<Integer> list2 = Arrays.asList(2, 9);
        List<Integer> list3 = Arrays.asList(4, 11, 17);

        List<List<Integer>> summary = Arrays.asList(list1, list2, list3);

        System.out.println(summary);

        List<Integer> summaryList = summary.stream().flatMap(List::stream).toList();
        System.out.println(summaryList);



    }
}
