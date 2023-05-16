package com.yandex.exam.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws IOException {


        long start1 = System.currentTimeMillis();
        oneAlgorithm();
        System.out.println();
        System.out.println("Первый метод занял " + (System.currentTimeMillis() - start1) + " миллисекунд");

        long start2 = System.currentTimeMillis();
        twoAlgorithm();
        System.out.println();
        System.out.println("Второй метод занял " + (System.currentTimeMillis() - start2) + " миллисекунд");

    }

    private static void oneAlgorithm() throws FileNotFoundException {
        //        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        int[] incomeRequest = new int[n];
        for (int i = 0; i < n; i++) {
            incomeRequest[i] = scanner.nextInt();
        }
        int[] educationRequest = new int[n];
        for (int i = 0; i < n; i++) {
            educationRequest[i] = scanner.nextInt();
        }
        int[] childRequest = new int[n];
        for (int i = 0; i < n; i++) {
            childRequest[i] = scanner.nextInt();
        }
        int schoolmate = scanner.nextInt();
        int[] income = new int[schoolmate];
        for (int i = 0; i < schoolmate; i++) {
            income[i] = scanner.nextInt();
        }
        int[] education = new int[schoolmate];
        for (int i = 0; i < schoolmate; i++) {
            education[i] = scanner.nextInt();
        }
        int[] child = new int[schoolmate];
        for (int i = 0; i < schoolmate; i++) {
            child[i] = scanner.nextInt();
        }

        scanner.close();

        int[] result = new int[schoolmate];
        Arrays.fill(result, 0);
        boolean x = false;
        boolean y = false;
        for (int i = 0; i < schoolmate; i++) {
            int inc = income[i];
            int ed = education[i];
            int ch = child[i];
            for (int j = 0; j < n; j++) {
                x = (incomeRequest[j] <= inc && educationRequest[j] <= ed);
                y = (childRequest[j] == 1 && !x && ch == j + 1);
                if ((x || y) && result[i] == 0) {
                    result[i] = j + 1;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(result[i]);
        }
    }

    private static void twoAlgorithm() throws FileNotFoundException {
        //        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        ArrayList<Region> regions = new ArrayList<>();
        Set<Region> regionForEducation = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Region region = new Region();
            region.position = i + 1;
            region.minIncome = scanner.nextInt();
            regions.add(region);
        }
        for (int i = 0; i < n; i++) {
            regions.get(i).needEducation = scanner.nextInt();
            if (regions.get(i).needEducation == 0){
                regionForEducation.add(regions.get(i));
            }
        }
        for (int i = 0; i < n; i++) {
            regions.get(i).child = scanner.nextInt();
        }
        int s = scanner.nextInt();
        ArrayList<Schoolmate> schoolmates = new ArrayList<>();
        regions.sort((r1, r2) -> {
            if (r1.minIncome != r2.minIncome) {
                return r1.minIncome - r2.minIncome;
            } else {
                return r1.position - r2.position;
            }
        });
        for (int i = 0; i < s; i++) {
            Schoolmate schoolmate = new Schoolmate();
            int income = scanner.nextInt();
            int t = getRegionForIncome(regions, income);
            if (t != -1){
                schoolmate.income = new HashSet<>(regions.subList(0, t));
            } else {
                schoolmate.income = new HashSet<>(regions);
            }
            schoolmates.add(schoolmate);
        }

        for (int i = 0; i < s; i++) {
            int education = scanner.nextInt();
            if (education == 1){
                schoolmates.get(i).education = new HashSet<>(regions);
            } else {
                schoolmates.get(i).education = regionForEducation;
            }
        }

        regions.sort(Comparator.comparing(region -> region.position));

        for (int i = 0; i < s; i++) {
            int child = scanner.nextInt();
            if (child != 0 && regions.get(child - 1).child == 1){
                schoolmates.get(i).child = regions.get(child - 1);
            } else {
                schoolmates.get(i).child = null;
            }
        }

        scanner.close();

        for (int i = 0; i < s; i++) {
            int priorityRegion = 0;
            Set<Region> availableRegions = new HashSet<>(schoolmates.get(i).income);
            availableRegions.retainAll(schoolmates.get(i).education);
            ArrayList<Region> r = new ArrayList<>(availableRegions);
            r.sort(Comparator.comparing(region -> region.position));
            if (r.size() != 0){
                priorityRegion = r.get(0).position;
            }
            if (schoolmates.get(i).child == null) {
                schoolmates.get(i).result = priorityRegion;
            } else if (priorityRegion == 0) {
                schoolmates.get(i).result = schoolmates.get(i).child.position;
            } else {
                schoolmates.get(i).result = Math.min(schoolmates.get(i).child.position, priorityRegion);
            }
        }

        for (int i = 0; i < schoolmates.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(schoolmates.get(i).result);
        }
    }

    private static class Region {
        public int position;
        public int minIncome;
        public int needEducation;
        public int child;
    }

    private static class Schoolmate {
        public Set<Region> income;
        public Set<Region> education;
        public Region child;
        public int result;
    }

    private static int getRegionForIncome(List<Region> list, int income) {
        if (income < list.get(0).minIncome) {
            return 0;
        } else if (income >= list.get(list.size() - 1).minIncome) {
            return -1;
        }
        int left = 0;
        int right = list.size();
        int y = 0;
        int region = -1;
        while (left < right) {
            y = (left + right) / 2;
            if (income >= list.get(y).minIncome && income < list.get(y + 1).minIncome) {
                int t = list.get(y).minIncome;
                while (y < list.size() - 2 && list.get(y + 1).minIncome == t){
                    y++;
                }
                region = y;
                break;
            } else if (y < list.size() - 2 && income >= list.get(y + 1).minIncome) {
                left = ++y;
            } else if (income < list.get(y).minIncome) {
                right = --y;
            }
        }
            if (region == -1) {
            region = left;
        }
        return region + 1;
    }
}
