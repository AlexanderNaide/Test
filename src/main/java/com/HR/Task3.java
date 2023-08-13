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
                if (leftAnt.nextStep() == rightAnt.getCoordinate()) {
                    leftAnt.reverse();
                    rightAnt.reverse();
                }
                leftAnt.go();
                if (rightAnt.nextStep() == leftAnt.getCoordinate()) {
                    leftAnt.reverse();
                    rightAnt.reverse();
                }
                rightAnt.go();
                count++;
            }
        }

        return count;
    }

    @AllArgsConstructor
    @Getter
    private static class Ant {
        private int coordinate;
        private int step;

        public void reverse() {
            step = step * -1;
        }

        public void go(){
            coordinate += step;
        }

        public int nextStep(){
            return coordinate + step;
        }
    }
}
