package com.yandex.exam.task3;

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
        while(input.get(left).price < input.get(right).price){
            one = input.get(left);
            while(input.get(left).price < input.get(right).price){
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
            right = input.size() - 1;
            left += 1;
        }

        ArrayList<Order> maxProfit = new ArrayList<>();
        int tempProfit = 0;
        for (int i = 0; i < orders.size() - 1; i++) {
            ArrayList<Order> currentThread = new ArrayList<>();
            Order order = orders.get(i);
            int closeDay = order.closeDay;
            currentThread.add(order);
            int currentProfit = order.profit;
            for (int j = i + 1; j < orders.size() - 1; j++) {
                Order anotherOrder = orders.get(j);
                if(anotherOrder.openDay > closeDay){
                    currentThread.add(anotherOrder);
                    currentProfit += anotherOrder.profit;
                    break;
                }
            }
            if (currentProfit > tempProfit){
                tempProfit = currentProfit;
                maxProfit = currentThread;
            }
        }

        System.out.println(maxProfit.size());
        if (maxProfit.size() != 0){
            maxProfit.forEach(o -> System.out.println(o.openDay + " " + o.closeDay));
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