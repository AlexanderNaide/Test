package com.algorithm.armstrong;

public class IntAlgorithm {

    private final Logger logger = new Logger();

    public void calculate(int max) {
        for (int i = 0; i < max; i++) {

            int length = ArmstrongUtil.length(i);
            int[] split = ArmstrongUtil.split(i, length);

            int result = 0;
            for (int j = 0; j < split.length; j++) {
                result += Math.pow(split[j], length);
            }
            if (result == i) {
                logger.log(result);
//                System.out.println("Armstrong number found: " + result);
            }
        }
        logger.print();
    }

    public void calculateMatrix(int max) {
        for (int i = 0; i < max; i++) {

            int length = ArmstrongUtil.length(i);
            int[] split = ArmstrongUtil.split(i, length);

            int result = 0;
            for (int k : split) {
                result += ArmstrongUtil.MATRIX[k][length];
            }
            if (result == i) {
                logger.log(result);
//                System.out.println("Armstrong number found: " + result);
            }
        }
        logger.print();
    }


}
