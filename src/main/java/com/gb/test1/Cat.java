package com.gb.test1;

public class Cat {
    String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat (Cat cat, String newName) {
        this(newName);
        System.out.print(cat.name);
        cat.name = "Mia";
    }

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
