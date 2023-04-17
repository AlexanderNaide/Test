package com.gb.interview.homework1;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Polymorphism {
    public static void main(String[] args) {

        ArrayList<GeometricalFigure> list = new ArrayList<>(List.of(
                new Circle("�������"),
                new Square("�������"),
                new Triangle("�����")
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
        System.out.println("���� ��������� � " + color + " ����.");
    }
}

class Circle extends GeometricalFigure{
    public Circle(String color) {
        super(color);
    }
    @Override
    public void paint() {
        System.out.println("� ���� � � �������� � " + color + " ����.");
    }
}

class Square extends GeometricalFigure{
    public Square(String color) {
        super(color);
    }
    @Override
    public void paint() {
        System.out.println("� ������� � � �������� � " + color + " ����.");
    }
}

class Triangle extends GeometricalFigure{
    public Triangle(String color) {
        super(color);
    }
    @Override
    public void paint() {
        System.out.println("� ����������� � � �������� � " + color + " ����.");
    }
}
