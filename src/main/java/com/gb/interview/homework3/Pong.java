package com.gb.interview.homework3;

public class Pong implements Runnable{

    private final Task1 task1;

    public Pong(Task1 task1) {
        this.task1 = task1;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            task1.pong();
        }
    }
}
