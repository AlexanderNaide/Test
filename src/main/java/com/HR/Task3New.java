package com.HR;

public class Task3New {
    public static void main(String[] args) {

        System.out.println(move(4, 1, 3)); //result 2
        System.out.println(move(4, 4, 1)); //result 3
        System.out.println(move(4, 4, 3)); //result 1
        System.out.println(move(3, 3, 1)); //result 2

    }

    public static int move(int n, int left, int right) {
        int count = 0;
        int leftStep = -1;
        int rightStep = 1;

        while (true) {
            if (left < 0 || left > n) {
                break;
            } else if (right < 0 || right > n) {
                break;
            } else {
                if (left + leftStep == right) {
                    leftStep = leftStep * -1;
                    rightStep = rightStep * -1;
                }
                left += leftStep;
                if (right + rightStep == left) {
                    leftStep = leftStep * -1;
                    rightStep = rightStep * -1;
                }
                right += rightStep;
                count++;
            }
        }

        return count;
    }
}
