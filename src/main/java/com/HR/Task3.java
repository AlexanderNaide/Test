package com.HR;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Task3 {
    public static void main(String[] args) {

        System.out.println(Move(4, 1, 3));
        System.out.println(Move(4, 4, 1));
        System.out.println(Move(4, 4, 3));
        System.out.println(Move(3, 3, 1));

    }

    public static int Move(int n, int left, int right) {
        int count = 0;
        Ant leftAnt = new Ant(left, -1);
        Ant rightAnt = new Ant(right, 1);

        while (true) {
            if (leftAnt.getCoordinate() < 0 || leftAnt.getCoordinate() > n) {
                break;
            } else if (rightAnt.getCoordinate() < 0 || rightAnt.getCoordinate() > n) {
                break;
            } else {
                if (leftAnt.getCoordinate() + leftAnt.getStep() == rightAnt.getCoordinate()) {
                    leftAnt.reverse();
                    rightAnt.reverse();
                }
                leftAnt.setCoordinate(leftAnt.getCoordinate() + leftAnt.getStep());
                if (rightAnt.getCoordinate() + rightAnt.getStep() == leftAnt.getCoordinate()) {
                    leftAnt.reverse();
                    rightAnt.reverse();
                }
                rightAnt.setCoordinate(rightAnt.getCoordinate() + rightAnt.getStep());
                count++;
            }
        }

        return count;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    private static class Ant {
        private int coordinate;
        private int step;

        public void reverse() {
            step = step * -1;
        }
    }
}
