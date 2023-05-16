package com.yandex.study.task4;

import java.io.*;
import java.util.*;

public class Synonym {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\yandex\\study\\task4\\synonym"));
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>(n * 2);
        for (int i = 1; i <= n; i++) {
            list.addAll(List.of(reader.readLine().split(" ")));
        }
        String searchWord = reader.readLine();
        reader.close();

        int index = list.indexOf(searchWord);
        if (index % 2 == 0){
            System.out.println(list.get(index + 1));
        } else {
            System.out.println(list.get(index - 1));
        }
    }
}