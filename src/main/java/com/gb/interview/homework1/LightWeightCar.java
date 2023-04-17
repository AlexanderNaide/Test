package com.gb.interview.homework1;

interface Moveable { // <- Следует ли считать ошибкой написание названий? Если да, то наверно следует написать Movable
    void move();
}
interface Stopable { // <- Опять же, что это за слово? Может Stopping?
    void stop();
}

abstract class Car {
    public Engine engine; // <- Модификатор доступа переменных следует указывать как private, тем более, что установлен геттер и сеттер на это поле.
    private String color;
    private String name;

    protected void start() { // <- Вот тут следует указать модификатор Public, чтобы методы объектов были одинаково видны, если нет необходимости в "особой" логике.
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class LightWeightCar extends Car implements Moveable {
    @Override
    void open() { // <- Вот тут следует установить модификатор доступа как и у второго метода, иначе возможна ситуация, когда один метод виден, а второй нет, если нет необходимости в "особой" логике.
        System.out.println("Car is open");
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}


class Lorry extends Car, Moveable, Stopable { // <- Moveable и Stopable это интерфейсы, соответственно мы не наследуемся от них, а имплементируем.
    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }
    // <- Класс Car - абстрактный, то есть необходимо переопределить абстрактный метод open() или назначить класс Lorry тоже абстрактным.
}
