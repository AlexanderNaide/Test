package com.tinkoff.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));

        ArrayList<Integer> growthPeople =new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            growthPeople.add(scanner.nextInt());
        }

        scanner.close();

        int currentGrowthPlus = -1;
        int currentGrowthMinus = -1;
        for (int i = 0; i < growthPeople.size(); i++) {
//            System.out.println(growthPeople.get(i));
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
//            System.out.println(currentGrowthPlus + " / " + currentGrowthMinus);
        }

        if (currentGrowthPlus != -1 || currentGrowthMinus != -1){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
