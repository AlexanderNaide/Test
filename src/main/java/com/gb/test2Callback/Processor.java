package com.gb.test2Callback;

public class Processor implements Runnable {
    Callback callback;
    public Processor(Callback callback) {
        this.callback = callback;
    }

    public void print(String message){
        System.out.println(message);
    }

    @Override
    public void run() {
        StringBuilder message = new StringBuilder();
        String[] arc = {"S", "a", "T", "a", "L"};

        for (String s : arc) {
            message.append(s);
            callback.onReceive(String.valueOf(message));
        }
    }
}
