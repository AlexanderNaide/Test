package com.algorithm.armstrong;

import java.util.Map;
import java.util.TreeMap;

public class Logger {

    private final Long start = System.currentTimeMillis();

    public static boolean flag = false;

    private final Map<Integer, Long> results = new TreeMap<>();

    public void log(int value){
        if (flag){
            results.putIfAbsent(value, System.currentTimeMillis() - start);
        }
    }

    public void print(){
        if (flag) {
            for (Map.Entry<Integer, Long> entry : results.entrySet()) {
                System.out.println(entry.getValue() + " found armstrong number: " + entry.getKey());
            }
        }
    }

}
