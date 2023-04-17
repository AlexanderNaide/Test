package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * �� ����� ���������� ��������� ������ ���� ����� ������������� ��������� ����� ������.
 * ������ ���� ���� ������ ������������ ����� ����������� �����, �� ������� l � �� ������� r.
 * ����� ����, ����������� ����� � ����� ����������� ������ �������� �� ���������� ����.
 * ��������, ����� 999 �������� ��� ��� ����������, � ����� 123 � ���.
 * ����� ������������ ����� ��������� ������ ������ ������� ����?
 *
 * ������ ������� ������:
 * � ������������ ������ �������� ��� ����������� ����� l,r (1?l,r?10^18)� ����������� �� ����� ����.
 * �������� ��������, ��� ��� ����� �� ��������� � 32-������ ��� ������, ����������� 64-������ ��� �������������
 *
 * ������ �������� ������:
 * �������� ���� ����� � ���������� ������, ������� ����� ������� ����.
 *
 * ���������:
 * � ������ ����� ���� �������� ������ [4,5,6,7].
 * �� ������ ����� �������� ��� �����, ������� 11, �� 11 �� 99.
 *
 * ������� ������:
 * ������ 1:
 * ����: 4  7
 * �����: 4
 * ������ 2:
 * ����: 10  100
 * �����: 9
 *
 * ------------- �� -------------
 *
 */

public class task05 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        long startMem = Runtime.getRuntime().freeMemory();
        Scanner scanner = new Scanner(new FileInputStream("C:\\input.txt"));
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        scanner.close();
        long a = getStart(l);
        System.out.println("l / a = " + l + " / " + a);


        if (a > 1){
            long b = a;
            while (b < l) {
                b += a;
            }
            l = b;
        }

        int count = 0;
        for (long i = l; i <= r;) {
            System.out.println(i);
            count++;
            if(digit(i + 1) > digit(i)){
                i = getStart(i + 1);
            } else {
                i += getStart(i);
            }
        }
        System.out.println(count);
        System.out.println("�����, ���: " + (System.currentTimeMillis() - startTime)/1000);
        System.out.println("������, mB : " + (startMem - Runtime.getRuntime().freeMemory()) / (8 * 1024));
    }

    public static Long getStart(long x){
        long[] dd = new long[digit(x)];
        Arrays.fill(dd, 1);
        stringBuilder.setLength(0);
        for (long l : dd) {
            stringBuilder.append(l);
        }
        return Long.parseLong(String.valueOf(stringBuilder));
    }

    public static Integer digit(long x){
        int a = 0;
        while (x > 0){
            a++;
            x = x / 10;
        }
        return a;
    }
}
