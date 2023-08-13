package com.HR;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Task3New {
    public static void main(String[] args) {

        System.out.println(Move(4, 1, 3));
        System.out.println(Move(4, 4, 1));
        System.out.println(Move(4, 4, 3));
        System.out.println(Move(3, 3, 1));

    }

    public static int Move(int n, int left, int right) {
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
