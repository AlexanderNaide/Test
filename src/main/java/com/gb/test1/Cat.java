package com.gb.test1;

public class Cat {
    String name;

    private static Cat renameCat(Cat cat) {
        System.out.print(cat.name);
        cat = new Cat();
        cat.name = "Mia";
        return cat;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Yuna";
        renameCat(cat);
        System.out.print(cat.name);
    }
}
