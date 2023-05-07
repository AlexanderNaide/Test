package com.algorithm.armstrong;

public class Main {
    public static void main(String[] args) {

        warmup();
        Logger.flag = true;

//        System.out.println("Standard string algorithm : ");
//        new BasicAlgorithm().calculate(10_000_000);
//        System.out.println("Integer algorithm : ");
//        new IntAlgorithm().calculate(10_000_000);
//        System.out.println("Integer algorithm with matrix : ");
//        new IntAlgorithm().calculateMatrix(10_000_000);
        System.out.println("Optimal algorithm : ");
        new ArrayAlgorithm().calculate(Integer.MAX_VALUE);

        // 0:44:00


    }

    private static void warmup(){
        for (int i = 0; i < 100; i++) {
//            new BasicAlgorithm().calculate(100_000);
//            new IntAlgorithm().calculate(100_000);
//            new IntAlgorithm().calculateMatrix(100_000);
            new ArrayAlgorithm().calculate(10_000_000);
        }
    }
}
