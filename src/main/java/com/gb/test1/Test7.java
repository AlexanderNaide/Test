package com.gb.test1;

public class Test7 extends Thread{
    Test7(){
        System.out.print(" MyThread");
    }
    public void run(){
        System.out.print(" bar");
    }
    public void run(String s){
        System.out.println(" baz");
    }
}
class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new Test7(){
            public void run() {
                System.out.println(" foo");
            }
        };
        t.start();
    }
}
