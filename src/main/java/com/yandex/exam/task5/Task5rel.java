package com.yandex.exam.task5;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task5rel {
    public static void main(String[] args) throws IOException {
        //        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/main/java/com/yandex/task5/input.txt"));
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
        long fullCount = 0;
        Set<Integer> temp;
        int j;
        int next;
        for (int i = 0; i < n; i++) {
            mi.forEach((u, v) -> v.reset());
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
                if (temp.size() < 26){
                    temp.add(currentSymbol.m);
                    fullCount = fullCount + temp.size();
                    next = currentSymbol.next;
                    j++;
                } else {
                    fullCount = fullCount + (long) temp.size() * (k - j);
                    break;
                }
            }
        }
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