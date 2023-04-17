package com.tinkoff.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class task04 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        map.forEach((k, v) -> System.out.println(k + " - " + v));

        Collection<Integer> c = map.values();

        int i = Collections.min(c) * map.size();

        while (!inPermanentMap(map)){
            inDecrementMap(map);
        }

        int j = 0;
        for (Integer value : map.values()) {
            j += value;
        }

        System.out.println(Math.max(i, j));

    }

    public static boolean inPermanentMap(Map<Integer, Integer> map){
        ArrayList<Integer> list = new ArrayList<>(map.values());
        int i = list.get(0);
        for (Integer integer : list) {
            if(integer != i){
                return false;
            }
        }
        return true;
    }

    public static void inDecrementMap(Map<Integer, Integer> map){
        Collection<Integer> c = map.values();
        int i = Collections.min(c);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == i){
                map.remove(entry.getKey());
            }
        }

//        map.forEach((k, v) -> System.out.println(k + " - " + v));
    }


}
