package com.gb.interview.homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        testMainLinkedList();

        testMainArrayList();


    }

    private static void testMainLinkedList() {
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


        MainLinkedList<Integer> integerMainLinkedList = new MainLinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(integerMainLinkedList);
        integerMainLinkedList.add(10);
        System.out.println(integerMainLinkedList);
        integerMainLinkedList.del(6);
        System.out.println(integerMainLinkedList);
        integerMainLinkedList.add(0, 0);
        System.out.println(integerMainLinkedList);


        MainLinkedList<Object> objectMainLinkedList = new MainLinkedList<>(List.of(new String("string"), new Object(), new ArrayList<>(List.of(1, 2, 3))));
        System.out.println(objectMainLinkedList);
        objectMainLinkedList.remove(1);
        System.out.println(objectMainLinkedList);

    }

    private static void testMainArrayList(){
        MainArrayList<String> arrayList = new MainArrayList<>();
        arrayList.add("str1");
        arrayList.add("str2");
        arrayList.add("str3");
        arrayList.add("str4");
        arrayList.add("str5");
        arrayList.add("str6");
        arrayList.add("str7");
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        arrayList.add(0, "str0");
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        arrayList.add(6, "str5a");
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        arrayList.del("str2");
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        arrayList.remove(3);
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        System.out.println(arrayList.contains("str5a"));
        System.out.println(arrayList.search("str5a"));
        System.out.println(arrayList.search("str6"));
        System.out.println(arrayList.search("str7"));


        MainArrayList<Integer> integerMainArrayList = new MainArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(integerMainArrayList);
        integerMainArrayList.add(10);
        System.out.println(integerMainArrayList);
        integerMainArrayList.del(6);
        System.out.println(integerMainArrayList);
        integerMainArrayList.add(0, 0);
        System.out.println(integerMainArrayList);


        MainArrayList<Object> objectMainArrayList = new MainArrayList<>(List.of(new String("string"), new Object(), new ArrayList<>(List.of(1, 2, 3))));
        System.out.println(objectMainArrayList);
        objectMainArrayList.remove(2);
        System.out.println(objectMainArrayList);
    }


}
