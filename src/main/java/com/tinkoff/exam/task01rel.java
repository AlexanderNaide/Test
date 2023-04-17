package com.tinkoff.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class task01rel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> growthPeople =new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            growthPeople.add(scanner.nextInt());
        }

        scanner.close();

        int currentGrowthPlus = -1;
        int currentGrowthMinus = -1;
        for (int i = 0; i < growthPeople.size(); i++) {
            if(i == 0){
                currentGrowthPlus = growthPeople.get(i);
                currentGrowthMinus = growthPeople.get(i);
            } else {
                if (growthPeople.get(i) < currentGrowthPlus && currentGrowthPlus != -1) {
                    currentGrowthPlus = -1;
                } else if (currentGrowthPlus != -1) {
                    currentGrowthPlus = growthPeople.get(i);
                }
                if (growthPeople.get(i) > currentGrowthMinus && currentGrowthMinus != -1) {
                    currentGrowthMinus = -1;
                } else if (currentGrowthMinus != -1)  {
                    currentGrowthMinus = growthPeople.get(i);
                }
            }
        }

        if (currentGrowthPlus != -1 || currentGrowthMinus != -1){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
