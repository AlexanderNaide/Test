package com.tinkoff.trening;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class task07rel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Graph> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Graph(i, scanner.nextInt()));
        }
        scanner.close();
        ArrayList<ArrayList<Graph>> history = new ArrayList<>();
        boolean flag = false;
        for (Graph pos : arr) {
            ArrayList<Graph> temp = new ArrayList<>();
            while (!temp.contains(pos)) {
                temp.add(pos);
                pos = arr.get(pos.second - 1);
            }
            history.add(new ArrayList<>(temp));
            if(temp.size() == arr.size() && temp.get(0).current + 1 == temp.get(temp.size() - 1).second){
                flag = true;
                break;
            }
        }

        history.sort(Comparator.comparingInt(ArrayList::size));
        ArrayList<Graph> result = history.get(history.size() - 1);
        int pos = -1;
        int newCell = -1;
        if (result.size() == arr.size() && !flag && ((result.get(result.size() - 1).current + 1) != result.get(0).current + 1)){
            pos = (result.get(result.size() - 1).current + 1);
            newCell = result.get(0).current + 1;
        }
        System.out.println(pos + "  " + newCell);
    }

    private static class Graph{
        int current;
        int second;

        public Graph(int current, int second) {
            this.current = current;
            this.second = second;
        }
    }
}