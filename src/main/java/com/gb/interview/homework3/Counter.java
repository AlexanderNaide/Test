package com.gb.interview.homework3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long counter = 0L;
    Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try {
            counter++;
            System.out.println(counter + " ");
        } finally {
            lock.unlock();
        }
    }

    public long getCounter(){
        return counter;
    }
}
