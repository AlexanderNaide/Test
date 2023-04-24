package com.gb.test1;

import java.util.*;

public class newTest {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 5, 14, 3));
        Set<Integer> b = new HashSet<>(Arrays.asList(7, 3, 9, 14));
        Set<Integer> c = new HashSet<>(a);
        c.retainAll(b);
        System.out.println(c);



    }


}
