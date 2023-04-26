package com.yandex.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Task5 {
    public static void main(String[] args) throws IOException {
        //        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/main/java/com/yandex/task5/input.txt"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();

//        Map<Integer, Integer> mi = new LinkedHashMap<>();
        ArrayList<Integer> mi = new ArrayList<>();
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            mi.add(((int) chars[i]) - 97);
//            mi.put(((int) chars[i]) - 97, 0);
        }
        int[] pi = new int[n];
        int[] di = new int[n];
        for (int i = 0; i < n; i++) {
            pi[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            di[i] = scanner.nextInt();
        }
        scanner.close();
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            temp.clear();
            int m = mi.get(i);
            int p = i;
            int j = 0;
            while (j < k){
//                                    System.out.println("mi = " + (((j) / n) + 1));
                System.out.println(Character.toChars(m + 97));
                if (!temp.contains(m)){
                    temp.add(m);
                    count +=  1;
                    m = mi.get(pi[p] - 1);
                    j++;
                } else {

//                    System.out.println("--------------");
//                    System.out.println("было " + m + " - " + Arrays.toString(Character.toChars(m + 97)));
//                    System.out.println("проверка:");
//                    System.out.println("m = " + m);
//                    System.out.println("mi = " + ((k + 1) / n));
//                    System.out.println("p = " + p);
//                    System.out.println("d = " + di[p]);

                    m = (m + ((j / n + 1) - 1) * di[p]) % 26;
//                    System.out.println("стало " + m + " - " + Arrays.toString(Character.toChars(m + 97)));

//                    System.out.println("--------------");
                }

                p = pi[p] - 1;
                System.out.println(temp.stream().map(o -> (char) (o + 97)).toList() + " - " + count);
            }
            System.out.println(temp.stream().map(o -> (char) (o + 97)).toList());
        }

        System.out.println(count);

        System.out.println((25 + ((3 / n + 1) - 1) * di[2]) % 26);
//        System.out.println((25 + ((k + 1) / n - 1) * di[3 - 1]) % 26);


//        System.out.println("***********");
//
//        System.out.println(0 % 3);
//        System.out.println(1 % 3);
//        System.out.println(2 % 3);
//        System.out.println(3 % 3);
//        System.out.println(4 % 3);
//        System.out.println(5 % 3);
//        System.out.println(6 % 3);
//        System.out.println(7 % 3);





    }
}
