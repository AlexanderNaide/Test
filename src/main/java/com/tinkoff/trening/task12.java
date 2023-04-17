package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

/**
 * � ������� ���� ����������� ����� �����, ������ �� ������� ������ �� ���� ���������.
 * ��� ����������, ����� ����� �� 1 �� N ������ �� ����� ������� � ���� �������,
 * ���� ��� ������� ������ ������ ��������� � 1 �����.
 * ������ ������� ������:
 * ������ ������ �������� ����� N � ����������� �� �������� ��������� ����� � ��������
 * (1?N?10^18).
 * ������ ������ �������� ��� ����� A, B � C �������� ����������� ����� �����
 * (1?A,B,C?100000).
 * ������ �������� ������:
 * �������� ������������ ����� � ���������� ����, ������� ����� ������� � ��������.
 * ���������:
 * � ������ ������� �������� ��������� ��������:
 * 1=1
 * 1+4=5
 * 1+7=8
 * 1+4+4=9
 * 1+9=10
 * 1+4+7=12
 * 1+4+4+4=13
 * 1+4+9=14
 * 1+7+7=15
 * ������� ������
 * 15
 * 4  7  9
 *
 * -----���������: ��������� �������------
 */

public class task12 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Map<String, List<Integer>> map = new HashMap<>();
        map.put(String.valueOf(1), new ArrayList<>(List.of(1)));

        boolean finish = false;

        while (!finish){
            finish = true;
            Map<String, List<Integer>> newMap = new HashMap<>();
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                System.out.println("����� " + entry.getKey());
                for (int i : arr) {
                    if (entry.getValue().stream().reduce(0, Integer::sum) + i <= n && !map.containsKey(entry.getKey() + i)){
                        if(entry.getValue().get(entry.getValue().size() - 1) <= i) {
                            System.out.println("����� ��������: " + entry.getKey() + i);
                            finish = false;
                            newMap.put(entry.getKey() + i, Stream.concat(entry.getValue().stream(), Stream.of(i)).toList());
                        }
                    }
                }
            }
            System.out.println("�� ������ " + newMap.keySet());
            map.putAll(newMap);
        }

        System.out.println("!!! �������: " + map.size());
        map.forEach((k, v) -> System.out.println(v));

    }
}
