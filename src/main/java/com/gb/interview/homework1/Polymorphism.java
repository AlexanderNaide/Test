package com.gb.interview.homework1;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Polymorphism {
    public static void main(String[] args) {

        ArrayList<GeometricalFigure> list = new ArrayList<>(List.of(
                new Circle("зеленый"),
                new Square("красный"),
                new Triangle("синий")
        ));


        for (GeometricalFigure figure : list) {
            figure.paint();
        }

    }
}

class GeometricalFigure {

    protected String color;

    public GeometricalFigure(String color) {
        this.color = color;
    }

    public void paint(){
        System.out.println("Меня покрасили в " + color + " цвет.");
    }
}

class Circle extends GeometricalFigure{
    public Circle(String color) {
        super(color);
    }
    @Override
    public void paint() {
        System.out.println("Я круг и я покрашен в " + color + " цвет.");
    }
}

class Square extends GeometricalFigure{
    public Square(String color) {
        super(color);
    }
    @Override
    public void paint() {
        System.out.println("Я квадрат и я покрашен в " + color + " цвет.");
    }
}

class Triangle extends GeometricalFigure{
    public Triangle(String color) {
        super(color);
    }
    @Override
    public void paint() {
        System.out.println("Я треугольник и я покрашен в " + color + " цвет.");
    }
}
