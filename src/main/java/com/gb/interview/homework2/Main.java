package com.gb.interview.homework2;

public class Main {
    public static void main(String[] args) {

        MainLinkedList<String> mainList = new MainLinkedList<>();

        System.out.println(mainList);

        mainList.add("str1");
        mainList.add("str2");
        mainList.add("str3");
        mainList.add("str4");
        mainList.add("str5");
        mainList.add("str6");
        mainList.add("str7");
        mainList.add("str8");
        mainList.add("str9");
        mainList.add("str10");

        System.out.println(mainList);

        System.out.println(mainList.size());
        mainList.add(5, "str5a");
        System.out.println(mainList);
        System.out.println(mainList.size());

        System.out.println(mainList.get(6));

        System.out.println(mainList.contains("str1"));
        System.out.println(mainList.contains("str2"));
        System.out.println(mainList.contains("str100"));

        mainList.del("str10");
        System.out.println(mainList);
        System.out.println(mainList.size());

        mainList.remove(5);
        System.out.println(mainList);
        System.out.println(mainList.size());


    }
}
