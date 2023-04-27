package com.yandex.task5;

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
            symbol.memM = ((int) chars[i - 1]) - 97;
            symbol.memCount = 0;
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
        long count;
        Set<Integer> temp;
        int j;
        int next;

        for (int i = 0; i < n; i++) {

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
                if (!temp.contains(currentSymbol.m)){
                    count +=  1;
                    temp.add(currentSymbol.m);
                }
                fullCount = fullCount + count;
                next = currentSymbol.next;
                j++;
            }
        }
        System.out.println(fullCount);

    }

    private static class Symbol {
        int m;
        int next;
        int offset;
        int count;
        int memM;
        int memCount;
        public void reset(){
            m = memM;
            count = memCount;
        }
    }
}
