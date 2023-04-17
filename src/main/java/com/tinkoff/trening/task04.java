package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * � ����� ���� �������, �� ������� �������� n �����. ����� � ���� ���� ����������� �� ������, ��� k ���,
 * ����� ����� ����� � �������, ����� ���� ��������� ���� �� ������ ����, � �� �� ����� �������� ����� ������������ �����.
 * �� ����� ������������ �������� ����� ������ ��������� ����� ���� ����� �� ��������?
 * ������ ������� ������:
 * � ������ ������ �������� ����� ���� ��� ����� ����� n,k � ���������� ����� �� ������� � ����������� �� ����� ��������.
 * (1?n?1000,1?k?10^4) .
 * �� ������ ������ �������� n ����� ai � ����� �� ������� (1?ai?10^9)
 * ������ �������� ������:
 * � �������� ���� �������� ���� ����� � ������������ �������� ����� �������� � ��������� ������.
 * ���������:
 * � ������ ������� ����� ����� �������� ��� ������� �� ��� �������, � ���������� ���� ����� ����� ���������� �� 16.
 * �� ������ ������� ����� ������ ����� 85 �� 95.
 * � ������� ������� ����� ������ �� ������.
 * �������� ��������, ��� ����� ����� ��������� ����������� 32-������� ���� ������.
 * ������� ������:
 * ������ 1:
 * ����:
 * 5  2
 * 1  2  1  3  5
 * �����:
 * 16
 * ������ 2:
 * ����:
 * 3  1
 * 99  5  85
 * �����:
 * 10
 * ������ 3:
 * ����:
 * 1  10
 * 9999
 * �����:
 * 0
 *
 * ------------- �� --------------
 */

public class task04 {
    public static void main(String[] args) throws FileNotFoundException {
        int n;
        int t;
        int l;
        long starts;
        long finish;
        int[][] matrix;
        int max;
        int tf;
        int[] fArr;


//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));

        n = scanner.nextInt();
        t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();


        System.out.println(n + " " + t);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        starts = 0L;
        l = 0;
        for (int i : arr) {
            starts += i;
            int lv = String.valueOf(i).length();
            l = Math.max(l, lv);
        }



        System.out.println(starts);
        System.out.println();

        matrix = new int[n][l];

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            String line = String.valueOf(x);
            for (int j = 0; j < l; j++) {
                int xl;
                if ((l - 1) - j < line.length()){
                    xl = Integer.parseInt(String.valueOf(line.charAt(j - (l - line.length()))));
                } else {
                    xl = -1;
                }
                matrix[i][j] = xl;
            }
        }

        max = l;

        System.out.println("maxDischarge = " + max);

        // �������� �������
        for (int[] value : matrix) {
            for (int i : value) {
                System.out.print("[" + i + "]");
            }
            System.out.println();
        }

        tf = t;
        while(tf > 0){
            int a = 9;
            int x = -1;
            int y = -1;
            for (int i = 0; i < n; i++) {
                int b = matrix[i][l - max];
                if (b < a && b != -1){
                    a = b;
                    x = i;
                    y = l - max;
                }
            }
            if (x != -1){
                matrix[x][y] = 9;
                tf--;
            } else if (max > 1) {
                max--;
            } else {
                break;
            }
        }


        fArr = new int[n];
        for (int i = 0; i < n; i++) {
            StringBuilder res = new StringBuilder();
            for (int ints : matrix[i]) {
                if (ints != -1){
                    res.append(ints);
                }
            }
            fArr[i] = Integer.parseInt(res.toString());
            System.out.println(fArr[i]);
        }

        finish = 0L;
        for (int i : fArr) {
            finish += i;
        }

        for (int[] value : matrix) {
            for (int i : value) {
                System.out.print("[" + i + "]");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(finish - starts);
        System.out.println("������ : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));

    }


}
