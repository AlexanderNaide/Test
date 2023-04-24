package com.gb.interview.homework3;

public class Task2 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        for (int i = 0; i < 100; i++) {
            CounterIncremented ci = new CounterIncremented(counter);
            ci.start();
        }

        System.out.println(counter.getCounter());
    }
}
