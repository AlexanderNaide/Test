package com.algorithm.dinamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class backpack {
    public static void main(String[] args) {

        Thing recorder = new Thing("Магнитофон", 3000, 4);
        Thing laptop = new Thing("Ноутбук", 2000, 3);
        Thing guitar = new Thing("Гитара", 1500, 1);
        Thing iphone = new Thing("Айфон", 2000, 1);
        Thing brilliance = new Thing("Бриллиант", 3000, 2);

//        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(recorder, laptop, guitar));
//        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(guitar, laptop, recorder));
//        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(guitar, recorder, laptop));
//        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(guitar, recorder, laptop, iphone));
        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(guitar, recorder, laptop, iphone, brilliance));

        int maxValue = 4;


        Cell[][] grid = getCells(list, maxValue);


        System.out.println("---------------");
        Arrays.stream(grid[grid.length - 1]).forEach(System.out::println);


    }

    private static Cell[][] getCells(ArrayList<Thing> list, int maxValue) {

        Cell[][] grid = new Cell[list.size()][maxValue];

        for (int i = 0; i < list.size(); i++) {
            Thing t = list.get(i);
            System.out.println(t.name + " / " + t.weight + " >>>");
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || grid[i - 1][j] == null) {
                    grid[i][j] = t.weight <= (j + 1) ? new Cell(t) : null;
                } else if (t.weight > (j + 1)) {
                    grid[i][j] = grid[i - 1][j];
                } else {
                    if (t.weight == j + 1 || grid[i - 1][j - t.weight] == null) {
                        grid[i][j] = t.price < grid[i - 1][j].totalPrice ? grid[i - 1][j] : new Cell(t);
                    } else {
                        grid[i][j] = grid[i - 1][j].totalPrice < t.price + grid[i - 1][j - t.weight].totalPrice ? new Cell(t, grid[i - 1][j - t.weight]) : grid[i - 1][j];
                    }
                }
                System.out.println(" >>> " + grid[i][j]);
            }
        }
        return grid;
    }

    private static class Thing {
        String name;
        int price;
        int weight;

        public Thing(String name, int price, int weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }
    }

    private static class Cell {
        int totalPrice;
        ArrayList<Thing> selectedThing;
        int currentWeight;

        public Cell(Thing thing) {
            this.totalPrice = thing.price;
            this.selectedThing = new ArrayList<>();
            this.selectedThing.add(thing);
            this.currentWeight = thing.weight;
        }

        public Cell(Thing thing, Cell oldCell) {
            this.totalPrice = thing.price + oldCell.totalPrice;
            this.selectedThing = new ArrayList<>();
            this.selectedThing.addAll(oldCell.selectedThing);
            this.selectedThing.add(thing);
            this.currentWeight = thing.weight + oldCell.currentWeight;
        }

        @Override
        public String toString() {
            return "Вес - " + currentWeight + ", сумма - " + totalPrice + ", товаров " + selectedThing.size() + " (" + selectedThing.stream().map(e -> e.name).collect(Collectors.joining(", ")) + ")";
        }
    }
}
