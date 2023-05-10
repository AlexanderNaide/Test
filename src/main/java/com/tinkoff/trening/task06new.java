package com.tinkoff.trening;

import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * На физкультуре происходит разбиение по двум командам. Ребята выстроены в шеренгу, у каждого из них есть свой рост ai
 * Разбиение по командам произойдет по принципу «четный-нечетный» — все школьники с четным ростом
 * отправляются в одну команду, а нечетные — в другую.
 * В отличие от привычного урока, ребята не выстроились по росту.
 * Вместо привычного порядка они встали случайно. Теперь физрук Яша смотрит на шеренгу и думает —
 * может ли ровно одна пара учеников поменяться местами так, чтобы команды оказались такими же,
 * как и по принципу «первый-второй». Иначе говоря, он хочет получить такой порядок, при котором
 * все ученики с четным ростом стоят на четных позициях, а с нечетным — на нечетных.
 * Помогите Яше найти нужную замену.
 * Формат входных данных:
 * В первой строке находится число n(2?n?1000) — количество учеников в шеренге.
 * В следующей строке находится n натуральных чисел (1?ai?10^9) — рост учеников.
 * Формат выходных данных:
 * В единственной строке выведите
 * i и j — номера элементов, которые нужно поменять местами, чтобы добиться заданного условия
 * (1?i,j?n,i!=j). Если ответов несколько — разрешается вывести любой.
 * Если не существует способа поменять два элемента местами — выведите ?1?1.
 * Замечания:
 * В первом примере хотя бы один ученик с четным ростом будет стоять на нечетной позиции.
 * Во втором тесте замена приведет к неправильному состоянию.
 * В третьем тесте из условия замена приведет шеренгу к валидному состоянию [1,2].
 * Примеры данных:
 * Пример 1:
 * Ввод:
 * 4
 * 2  1  4  6
 * Вывод:
 * -1  -1
 * Пример 2:
 * Ввод:
 * 2
 * 1  2
 * Вывод:
 * -1  -1
 * Пример 3:
 * Ввод:
 * 2
 * 2  1
 * Вывод:
 * 1  2
 *
 * ------------ Частичное решение -------------
 */

public class task06new {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        long startMem = Runtime.getRuntime().freeMemory();


//        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\al121\\IdeaProjects\\Test\\src\\main\\java\\com\\tinkoff\\trening\\input6.txt"));
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\tinkoff\\trening\\input6.txt"));
        int n = scanner.nextInt();
        ArrayList<Integer> dev = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != sortedArr[i] || sortedArr[i] % 2 != (i + 1) % 2){
                dev.add(i + 1);
            }
        }

        System.out.println(dev);

        if (dev.size() == 2){
            System.out.println(dev.get(0) + "  " + dev.get(1));
        } else {
            System.out.println("-1 -1");
        }

        System.out.println("Время, сек: " + (System.currentTimeMillis() - startTime)/1000);
        System.out.println("Память, mB : " + (startMem - Runtime.getRuntime().freeMemory()) / (8 * 1024));
    }
}
