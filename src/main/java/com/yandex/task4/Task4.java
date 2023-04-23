package com.yandex.task4;

import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws IOException {


        long start1 = System.currentTimeMillis();
        oneAlgorithm();
        System.out.println();
        System.out.println("Первый метод занял " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        twoAlgorithm();
        System.out.println();
        System.out.println("Второй метод занял " + (System.currentTimeMillis() - start2));

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
        for (int i = 0; i < n; i++) {
            Region region = new Region();
            region.position = i + 1;
            region.minIncome = scanner.nextInt();
            regions.add(region);
        }
        for (int i = 0; i < n; i++) {
            regions.get(i).needEducation = scanner.nextInt();
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
            schoolmate.income = getRegionForIncome(regions, scanner.nextInt());
            schoolmates.add(schoolmate);
        }

        regions.sort((r1, r2) -> {
            if (r1.needEducation != r2.needEducation) {
                return r1.needEducation - r2.needEducation;
            } else {
                return r1.position - r2.position;
            }
        });

        for (int i = 0; i < s; i++) {
            schoolmates.get(i).education = getRegionForEducation(regions, scanner.nextInt());
        }

        regions.sort(Comparator.comparing(region -> region.position));

        for (int i = 0; i < s; i++) {
            int child = scanner.nextInt();
            if (child != 0 && regions.get(child - 1).child == 1){
                schoolmates.get(i).child = child;
            } else {
                schoolmates.get(i).child = 0;
            }
        }

        scanner.close();

        for (int i = 0; i < s; i++) {
            int sr;
            if (schoolmates.get(i).income == 0 || schoolmates.get(i).education == 0) {
                sr = 0;
            } else if (schoolmates.get(i).income == -1 && schoolmates.get(i).education == -1) {
                sr = regions.get(0).position;
            } else {
                if (schoolmates.get(i).income == -1) {
                    sr = schoolmates.get(i).education;
                } else if (schoolmates.get(i).education == -1) {
                    sr = schoolmates.get(i).income;
                } else {
                    sr = Math.min(schoolmates.get(i).income, schoolmates.get(i).education);
                }
            }

            if (schoolmates.get(i).child == 0) {
                schoolmates.get(i).result = sr;
            } else if (schoolmates.get(i).child != 0 && sr == 0) {
                schoolmates.get(i).result = schoolmates.get(i).child;
            } else {
                schoolmates.get(i).result = Math.min(schoolmates.get(i).child, sr);
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
        //        public int position;
        public int income;
        public int education;
        public int child;

        public int result;
    }

    private static int getRegionForIncome(List<Region> list, int income) {
        if (income < list.get(0).minIncome) {
            return 0;
        } else if (income > list.get(list.size() - 1).minIncome) {
            return -1;
        }
        int left = 0;
        int right = list.size();
        int y = 0;
        int region = -1;
        while (left < right) {
            y = (left + right) / 2;
            if (list.get(y).minIncome == income) {
                region = list.get(y).position;
                break;
            } else if (list.get(y).minIncome > income) {
                right = --y;
            } else {
                left = ++y;
            }
        }
        if (region == -1) {
            region = list.get(left).position;
        }
        return region;
    }

    private static int getRegionForEducation(List<Region> list, int education) {
        if (education == list.get(0).needEducation) {
            return list.get(0).position;
        } else if (education == 1) {
            return -1;
        } else {
            return 0;
        }
    }

}
