package com.algorithm.dinamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class backpack {
    public static void main(String[] args) {

        Thing recorder = new Thing("Магнитофон", 3000, 4);
        Thing laptop = new Thing("Ноутбук", 2000, 3);
        Thing guitar = new Thing("Гитара", 1500, 1);
        Thing iphone = new Thing("Айфон", 2000, 1);
//        Thing brilliance = new Thing("Бриллиант", 3000, 4);

//        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(recorder, laptop, guitar));
//        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(guitar, laptop, recorder));
        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(guitar, recorder, laptop));

        int maxValue = 4;

//        Cell[][] grid = getCellsVar1(list, maxValue);
        Cell[][] grid = getCellsVar2(list, maxValue);

        for (int i = 0; i < grid[0].length; i++) {
            System.out.println("-----------");
            Cell itogCell = grid[grid.length - 1][i];

            System.out.println(itogCell);
            itogCell.selectedThing.forEach(c -> System.out.println(c.name));
        }


    }

    private static Cell[][] getCellsVar2(ArrayList<Thing> list, int maxValue) {
        Cell[][] grid = new Cell[list.size()][maxValue];


        for (int i = 0; i < list.size(); i++) {
            Thing t = list.get(i);
            System.out.println(t.name + " >>>");
            for (int j = 0; j < grid[i].length; j++) {
                int c = 0;
                if (i == 0) c = 1;
                if ()


                if (i == 0 || grid[i - 1][j] == null){
                    grid[i][j] = t.weight <= (j + 1) ? new Cell(t) : null;
                } else {
                    if (t.weight < (j + 1)){
                        grid[i][j] = t.price < grid[i - 1][j].totalPrice ? grid[i - 1][j] : new Cell(t, grid[i][j - t.weight]);
                    } else if (t.weight == (j + 1)){
                        grid[i][j] = t.price < grid[i - 1][j].totalPrice ? grid[i - 1][j] : new Cell(t);
                    } else {
                        grid[i][j] = grid[i - 1][j];
                    }


                }

                System.out.println(" >>> " + grid[i][j]);

            }
        }
        return grid;
    }

    private static Cell[][] getCellsVar1(ArrayList<Thing> list, int maxValue) {
        Cell[][] grid = new Cell[list.size()][maxValue];


        for (int i = 0; i < list.size(); i++) {
            Thing t = list.get(i);
            for (int j = 0; j < grid[i].length; j++) {

                if (i > 0 && grid[i-1][j] != null){
                    Cell oldCell = grid[i-1][j];

                    if (t.price > oldCell.totalPrice){
                        if (t.weight <= (j + 1) - oldCell.currentWeight){
                            Cell newCell = new Cell(grid[i-1][j].totalPrice + t.price, t, grid[i-1][j].selectedThing);
                            grid[i][j] = newCell;
                        } else if (t.weight <= j + 1){
                            Cell newCell = new Cell(t);
                            grid[i][j] = newCell;
                        } else {
                            grid[i][j] = oldCell;
                        }
                    } else {
                        grid[i][j] = oldCell;
                    }

//                    grid[i][j] = grid[i-1][j].totalPrice > (t.weight <= (j + 1) - grid[i-1][j].currentWeight ? t.price : 0) ? grid[i-1][j] : new Cell(grid[i-1][j].totalPrice + t.price, t, grid[i-1][j].selectedThing);
                } else {
                    if (t.weight <= j + 1){
                        Cell newCell = new Cell(t);
                        grid[i][j] = newCell;
                    }
//                    grid[i][j] = t.weight <= j + 1 ? new Cell(t.price, t) : null;
                }
                System.out.println(grid[i][j]);
            }

        }
        return grid;
    }

    private static class Thing{
        String name;
        int price;
        int weight;

        public Thing(String name, int price, int weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }
    }

    private static class Cell{
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
            if (oldCell == null){
                this.totalPrice = thing.price;
                this.selectedThing = new ArrayList<>();
                this.selectedThing.add(thing);
                this.currentWeight = thing.weight;
            } else {
                this.totalPrice = thing.price + oldCell.totalPrice;
                this.selectedThing = new ArrayList<>();
                this.selectedThing.addAll(oldCell.selectedThing);
                this.selectedThing.add(thing);
                this.currentWeight = thing.weight + oldCell.currentWeight;
            }
        }

        public Cell(int totalPrice, Thing thing, ArrayList<Thing> oldThings) {
            this.totalPrice = totalPrice;
            this.selectedThing = new ArrayList<>();
            this.selectedThing.addAll(oldThings);
            this.selectedThing.add(thing);
            this.currentWeight = getCurrentWeight();
        }

        private int getCurrentWeight(){
            return selectedThing.stream().map(t -> t.weight).reduce(0, Integer::sum);
        }

        @Override
        public String toString() {
            return "Вес - " + currentWeight + ", сумма - " + totalPrice + ", товаров " + selectedThing.size();
        }
    }
}
