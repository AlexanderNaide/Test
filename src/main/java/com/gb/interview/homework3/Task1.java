package com.gb.interview.homework3;

public class Task1 {
    boolean flag = false;

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        new Ping(task1);
        new Pong(task1);
    }

    public synchronized void ping(){
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("Ping - ");
        flag = true;
        notify();
    }

    public synchronized void pong(){
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Pong");
        flag = false;
        notify();
    }
}
