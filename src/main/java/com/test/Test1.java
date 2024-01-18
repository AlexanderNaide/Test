package com.test;

public class Test1 {
    public static void main(String[] args) {
        String strId = "100-250";
        try{
            System.out.println(Integer.parseInt(strId));
        } catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
    }
}
