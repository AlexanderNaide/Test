package com.tinkoff.trening;

import java.util.*;
import java.util.stream.Stream;

public class task12rel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Map<String, List<Integer>> map = new HashMap<>();
        map.put(String.valueOf(1), new ArrayList<>(List.of(1)));

        boolean finish = false;

        while (!finish){
            finish = true;
            Map<String, List<Integer>> newMap = new HashMap<>();
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                for (int i : arr) {
                    if (entry.getValue().stream().reduce(0, Integer::sum) + i <= n && !map.containsKey(entry.getKey() + i)){
                        if(entry.getValue().get(entry.getValue().size() - 1) <= i) {
                            finish = false;
                            newMap.put(entry.getKey() + i, Stream.concat(entry.getValue().stream(), Stream.of(i)).toList());
                        }
                    }
                }
            }
            map.putAll(newMap);
        }

        System.out.println(map.size());
    }
}
