package com.gb.interview.homework1;

public class GeometricalFigure {
    private Double area;
    private String color;

    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void paint(String color){
        this.color = color;
        System.out.println("Меня покрасили в " + color + " цвет.");
    }
}

public class
