package com.algorithm;


// Задача в том, чтобы найти минимальный размер квадрата, на которые можно поделить всю ферму без остатка.
public class Farm {

    public static void main(String[] args) {
        Field field = new Field();
        field.length = 1680;
        field.width = 640;
        Field minField = splitField(field);
        System.out.println(minField.length + " * " + minField.width);
    }

    public static Field splitField(Field field){
//        System.out.println(" заход - ");
        Field newField;
        if (field.length > field.width){
            if(field.length % field.width == 0){
                newField = new Field();
                newField.length = field.width;
                newField.width = field.width;
                return newField;
            } else {
                newField = new Field();
                newField.width = field.width;
                newField.length = field.length - ((field.length / field.width) * field.width);
                return splitField(newField);
            }
        } else {
            if(field.width % field.length == 0){
                newField = new Field();
                newField.length = field.length;
                newField.width = field.length;
                return newField;
            } else {
                newField = new Field();
                newField.width = field.length;
                newField.length = field.width - ((field.width / field.length) * field.length);
                return splitField(newField);
            }
        }
    }

    public static class Field{
        public int length;
        public int width;
    }
}
