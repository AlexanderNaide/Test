package com.yandex.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/main/java/com/yandex/task3/input.txt"));
        int n = scanner.nextInt();
        ArrayList<Position> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(new Position(i + 1, scanner.nextInt()));
        }
        scanner.close();
        ArrayList<Order> orders = new ArrayList<>();

        input.sort(Comparator.comparing(p -> p.price));

        int left = 0;
        int right = input.size() - 1;
        Position one;
        Position two;
//        int pivot = (input.get(right).price - input.get(left).price) / 2;
//        while(input.get(left).price < pivot){
//        while(input.get(left).price < input.get(right).price){
        while(left < right){
            one = input.get(left);
            right = input.size() - 1;
//            while(input.get(right).price > pivot){
//            while(input.get(left).price < input.get(right).price){
            while(left < right){
                two = input.get(right);
                if (one.day < two.day){
                    Order order = new Order();
                    order.openPrice = one.price;
                    order.openDay = one.day;
                    order.closePrice = two.price;
                    order.closeDay = two.day;
                    order.profit = order.closePrice - order.openPrice;
                    orders.add(order);
                }
                right -= 1;
            }
            left += 1;
        }

        System.out.println(orders.size());
        System.out.println(orders.stream().map(o -> o.profit).toList());

        ArrayList<ArrayList<Order>> ddd = new ArrayList<>();
        for (int i = 0; i < orders.size() - 1; i++) {
            ddd.add(new ArrayList<>());
            Order order = orders.get(i);
            int closeDay = order.closeDay;
            ddd.get(i).add(order);
            for (int j = i + 1; j < orders.size() - 1; j++) {
                Order order1 = orders.get(j);
                if(order1.openDay > closeDay){
                    ddd.get(i).add(order1);
                }
            }
        }

        for (int i = 0; i < ddd.size() - 1; i++) {
            System.out.println(ddd.get(i).stream().map(o -> o.profit).toList());
        }













    }

    private static class Position{
        int day;
        int price;
        public Position(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    private static class Order{
        int openPrice;
        int openDay;
        int closePrice;
        int closeDay;
        int profit;
    }
}
