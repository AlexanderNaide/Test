package com.gb.test1;

public class mainClass {


    public static void main(String[] args) {
        String nn = "nn";
        Nirro n = new Nirro();
        n.init(nn);

        Collback collback = (n::print);

        collback.onReceive(nn);

        FunInt1 fn1 = nirro -> nirro.name;

        collback.onReceive(fn1.print1(n));

        new Thread(n::print).start();
    }
}
