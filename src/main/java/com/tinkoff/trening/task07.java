package com.tinkoff.trening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * В школе перед Новым Годом устраивают игру в Тайного Санту. Каждому ученику i выдается ученик ai,
 * которому он должен подарить подарок.
 * Костя, как администратор игры, определил каждому школьнику свое число ai.
 * Но потом его коллега Маша спросила: А правда ли, что если начать цепочку подарков от школьника 1 к школьнику a1,
 * потом aa1 и так далее, то цепочка замкнется на школьнике 1, после того, как задействует всех остальных учеников ровно по одному разу?
 * Костя не знает, правда это или нет, но он собирается изменить ровно одно число ai, чтобы получить конфигурацию, которая устроит Машу.
 * Помогите ему с этим.
 * Формат входных данных:
 * В первой строке находится натуральное число n — количество школьников (2≤n≤10^5).
 * В следующей строке находится n натуральных чисел ai — ученик, который достался Тайному Санте с номером i(1≤ai≤n).
 * Формат выходных данных:
 * В первой строке выведите два числа (1≤x,y≤n,x≠y) — номер ученика x, которому нужно изменить число ax, и новое значение ax.
 * Должно выполняться условие ax ≠ y. Если ответов несколько — выведите любой.
 * Если сделать это невозможно — выведите <<−1−1>>
 * Замечание:
 * В первом примере хотя бы один школьник будет дарить подарок сам себе.
 * Во втором примере после изменения происходят передачи подарков 1→2→3→1.
 * Примеры данных:
 * Пример 1:
 * Ввод:
 * 3
 * 1  2  3
 * Вывод:
 * -1  -1
 * Пример 2:
 * Ввод:
 * 3
 * 1  3  1
 * Вывод:
 * 1  2
 */

public class task07 {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        long startMem = Runtime.getRuntime().freeMemory();


//        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\al121\\IdeaProjects\\Test\\src\\main\\java\\com\\tinkoff\\trening\\input6.txt"));
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\GVoichuk\\IdeaProjects\\Test\\src\\main\\java\\com\\tinkoff\\trening\\input7.txt"));
        int n = scanner.nextInt();
        ArrayList<Graph> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Graph(i, scanner.nextInt()));
        }
        scanner.close();
        ArrayList<ArrayList<Graph>> history = new ArrayList<>();
        boolean flag = false;
        for (Graph pos : arr) {
            ArrayList<Graph> temp = new ArrayList<>();
            while (!temp.contains(pos)) {
                temp.add(pos);
                pos = arr.get(pos.second - 1);
            }
            history.add(new ArrayList<>(temp));
//            System.out.println(temp);
            if(temp.size() == arr.size() && temp.get(0).current + 1 == temp.get(temp.size() - 1).second){
                flag = true;
                break;
            }
        }

        history.sort(Comparator.comparingInt(ArrayList::size));
        ArrayList<Graph> result = history.get(history.size() - 1);
        int pos = -1;
        int newCell = -1;
        if (result.size() == arr.size() && !flag && ((result.get(result.size() - 1).current + 1) != result.get(0).current + 1)){
            pos = (result.get(result.size() - 1).current + 1);
            newCell = result.get(0).current + 1;
        }

        System.out.println(pos + "  " + newCell);

        System.out.println("Время, сек: " + (System.currentTimeMillis() - startTime)/1000);
        System.out.println("Память, mB : " + (startMem - Runtime.getRuntime().freeMemory()) / (8 * 1024));
    }

    private static class Graph{
        int current;
        int second;

        public Graph(int current, int second) {
            this.current = current;
            this.second = second;
        }

        @Override
        public String toString() {
            return "{cur - " + (current + 1) +
                    " / sec - " + second +
                    "}";
        }
    }
}
