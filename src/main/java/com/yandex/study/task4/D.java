package com.yandex.study.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\D"));
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        ArrayList<Integer> keyRecurs = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            keyRecurs.add(scanner.nextInt());
        }
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int key = scanner.nextInt();
            keyRecurs.set(key - 1, keyRecurs.get(key - 1) - 1);
        }
        scanner.close();

        for (Integer key : keyRecurs) {
            if (key < 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}