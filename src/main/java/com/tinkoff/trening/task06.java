package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * �� ����������� ���������� ��������� �� ���� ��������. ������ ��������� � �������, � ������� �� ��� ���� ���� ���� ai
 * ��������� �� �������� ���������� �� �������� �������-�������� � ��� ��������� � ������ ������
 * ������������ � ���� �������, � �������� � � ������.
 * � ������� �� ���������� �����, ������ �� ����������� �� �����.
 * ������ ���������� ������� ��� ������ ��������. ������ ������ ��� ������� �� ������� � ������ �
 * ����� �� ����� ���� ���� �������� ���������� ������� ���, ����� ������� ��������� ������ ��,
 * ��� � �� �������� �������-������. ����� ������, �� ����� �������� ����� �������, ��� �������
 * ��� ������� � ������ ������ ����� �� ������ ��������, � � �������� � �� ��������.
 * �������� ��� ����� ������ ������.
 * ������ ������� ������:
 * � ������ ������ ��������� ����� n(2?n?1000) � ���������� �������� � �������.
 * � ��������� ������ ��������� n ����������� ����� (1?ai?10^9) � ���� ��������.
 * ������ �������� ������:
 * � ������������ ������ ��������
 * i � j � ������ ���������, ������� ����� �������� �������, ����� �������� ��������� �������
 * (1?i,j?n,i!=j). ���� ������� ��������� � ����������� ������� �����.
 * ���� �� ���������� ������� �������� ��� �������� ������� � �������� ?1?1.
 * ���������:
 * � ������ ������� ���� �� ���� ������ � ������ ������ ����� ������ �� �������� �������.
 * �� ������ ����� ������ �������� � ������������� ���������.
 * � ������� ����� �� ������� ������ �������� ������� � ��������� ��������� [1,2].
 * ������� ������:
 * ������ 1:
 * ����:
 * 4
 * 2  1  4  6
 * �����:
 * -1  -1
 * ������ 2:
 * ����:
 * 2
 * 1  2
 * �����:
 * -1  -1
 * ������ 3:
 * ����:
 * 2
 * 2  1
 * �����:
 * 1  2
 *
 * ------------ ��������� ������� -------------
 */

public class task06 {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        long startMem = Runtime.getRuntime().freeMemory();
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));
        long n = scanner.nextLong();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        scanner.close();
        int a = -1;
        int b = -1;

        if (!checkingOrder(arr)){
            boolean f = false;
            for (int i = 0; i < arr.size() && !f; i++) {
                ArrayList<Integer> arrD = new ArrayList<>(arr);
//                System.out.println("������� ������� - " + arr);
                int x = arr.get(i);
                int y;
                for (int j = i + 1; j < arr.size(); j++) {
                    y = arr.get(j);
                    arrD.set(i, y);
                    arrD.set(j, x);
//                    System.out.println(arrD);
                    if (checkingOrder(arrD)){
                        a = i + 1;
                        b = j + 1;
                        f = true;
                        break;
                    } else {
                        arrD = new ArrayList<>(arr);
                    }
                }
            }
        }
        System.out.println(a + "  " + b);
        System.out.println("�����, ���: " + (System.currentTimeMillis() - startTime)/1000);
        System.out.println("������, mB : " + (startMem - Runtime.getRuntime().freeMemory()) / (8 * 1024));
    }

    public static boolean checkingOrder(ArrayList<Integer> arr){
        for (int i = 1; i <= arr.size(); i++) {
            if(!rest(i) && rest(arr.get(i - 1))){
                return false;
            }
        }
        return true;
    }

    public static boolean rest (int x){
        return (x % 2) == 0;
    }
}
