package com.algorithm.armstrong;

public class BasicAlgorithm {

    private final Logger logger = new Logger();
    public void calculate(int max){
        for (int i = 0; i < max; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            String[] split = s.split("");
            int result = 0;
            for (int j = 0; j < split.length; j++) {
                result += Math.pow(Integer.parseInt(split[j]), length);
            }
            if (result == i){
                logger.log(result);
//                System.out.println("Armstrong number found: " + result);
            }
        }
        logger.print();
    }
}
