package com.gb.interview.homework3;

public class CounterIncremented extends Thread{
    private final Counter counter;

    public CounterIncremented(Counter counter) {
        this.counter = counter;
    }

        @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.increment();
        }
    }
}
