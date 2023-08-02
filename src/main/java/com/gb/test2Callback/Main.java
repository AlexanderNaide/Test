package com.gb.test2Callback;

public class Main {
    public static void main(String[] args) {

        View view = new View();

        Processor processor = new Processor(view);

        Thread thread = new Thread(processor);
        thread.start();
    }
}
