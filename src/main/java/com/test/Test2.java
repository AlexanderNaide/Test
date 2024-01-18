package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(34654, 546, 95465));

        String str = list.stream()
                .map(i -> "; " + String.valueOf(i))
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .substring(2);

        System.out.println(str);
    }
}
