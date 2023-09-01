package com.gb.test1;

public class Test8 implements Runnable{
    public void run(){
        System.out.println("ta da");
    }

    public static void main(String[] args) {
        new Test8().run();
        new Thread(new Test8()).start();
    }
}
