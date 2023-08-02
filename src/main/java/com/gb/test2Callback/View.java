package com.gb.test2Callback;

public class View implements Callback{
    @Override
    public void onReceive(String message) {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
    }
}
