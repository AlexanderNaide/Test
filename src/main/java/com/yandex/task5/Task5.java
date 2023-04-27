package com.yandex.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Task5 {
    public static void main(String[] args) throws IOException {
        //        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/main/java/com/yandex/task5/input.txt"));
        long start = System.currentTimeMillis();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        HashMap<Integer, Symbol> mi = new HashMap<>();
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            Symbol symbol = new Symbol();
            symbol.tempM = ((int) chars[i - 1]) - 97;
            symbol.tempCount = 0;
            mi.put(i, symbol);
        }
        for (int i = 1; i <= n; i++) {
            mi.get(i).next = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            mi.get(i).offset = scanner.nextInt();
        }
        scanner.close();

        StringBuilder sb = new StringBuilder();

        long step1 = System.currentTimeMillis();
        System.out.println("Первый шаг: " + (step1 - start));

        long fullCount = 0;
        long count;
        Set<Integer> temp;
        int j;
        int next;

        for (int i = 0; i < n; i++) {

            sb.setLength(0);
            mi.forEach((u, v) -> v.reset());
            count = 0;
            temp = new HashSet<>();
            j = 0;
            next = 0;
            while (j < k){
                Symbol currentSymbol;
                if (j == 0){
                    currentSymbol = mi.get(i + 1);
                } else {
                    currentSymbol = mi.get(next);
                }
                currentSymbol.count += 1;

                if (currentSymbol.count > 1){
                    currentSymbol.m = (currentSymbol.m + (currentSymbol.count - 1) * currentSymbol.offset) % 26;
                    currentSymbol.count = 1;
                }
                sb.append((char) (currentSymbol.m + 97));
                if (!temp.contains(currentSymbol.m)){
                    count +=  1;
                    temp.add(currentSymbol.m);
                }
                fullCount = fullCount + count;
                System.out.println(sb + " - " + count);
                next = currentSymbol.next;
                j++;
            }
        }
        long step2 = System.currentTimeMillis();
        System.out.println("второй шаг: " + (step2 - step1));

        System.out.println(fullCount);


    }

    private static class Symbol {
        int m;
        int next;
        int offset;
        int count;

        int tempM;

        int tempCount;

        public void reset(){
            m = tempM;
            count = tempCount;
        }
    }
}
