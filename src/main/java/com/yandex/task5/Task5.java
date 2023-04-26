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
        HashMap<Integer, Symbol> mi = new HashMap<>();
//        HashMap<Integer, Symbol> reserv = new HashMap<>();

        scanner.nextLine();
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            Symbol symbol = new Symbol();
            symbol.m = ((int) chars[i - 1]) - 97;
            symbol.count = 0;
            mi.put(i, symbol);
        }
        for (int i = 1; i <= n; i++) {
            mi.get(i).next = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            mi.get(i).offset = scanner.nextInt();
//            reserv.put(i, new Symbol(mi.get(i)));
        }
        scanner.close();

        long fullCount = 0;
        long count;
        Set<Integer> temp;
        int j;
        int next;


        for (int i = 0; i < n; i++) {
            Map<Integer, Symbol> currentMi = new HashMap<>();
            mi.forEach((u, v) -> currentMi.put(u, v.clone()));

            count = 0;
            temp = new HashSet<>();
            j = 0;
            next = 0;
            while (j < k){
                Symbol currentSymbol;
                if (j == 0){
                    currentSymbol = currentMi.get(i + 1);
                } else {
                    currentSymbol = currentMi.get(next);
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

    private static class Symbol implements Cloneable {
        int m;
        int next;
        int offset;
        int count;

        public Symbol() {
        }

        public Symbol(Symbol symbol) {
            this.m = symbol.m;
            this.next = symbol.next;
            this.offset = symbol.offset;
            this.count = symbol.count;
        }

        @Override
        public Symbol clone() {
            try {
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return (Symbol) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
