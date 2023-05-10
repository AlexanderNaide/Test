package com.algorithm;

import java.util.*;

public class SampleGraph {
    public static void main(String[] args) {

        HashMap<String, LinkedList<String>> graph = new HashMap<>();
        graph.put("you", new LinkedList<>(List.of("alice", "bob", "claire")));
        graph.put("bob", new LinkedList<>(List.of("anuj", "peggy")));
        graph.put("alice", new LinkedList<>(List.of("peggy")));
        graph.put("claire", new LinkedList<>(List.of("thom", "jonny")));
        graph.put("anuj", new LinkedList<>());
        graph.put("peggy", new LinkedList<>());
        graph.put("thom", new LinkedList<>());
        graph.put("jonny", new LinkedList<>());


//        System.out.println(graph.get("you").get(0));

        bfs(graph, "you");


    }

    /**
     * суть поиска в ширину в том, что сначала обходятся дочерние элементы, а потом их дочерние и затем их и т.д.
     *      то есть, заходя в узел и если этот узел не является искомым - мы не проверяем его связи, а добавляем их в конец очереди - вот и весь секрет
     *      Еще надо отдельно сохранить проверенные узлы (или как-то пометить их, иначе программа зациклится.
     *      Формально алгоритм выглядит так:
     *         - Извлеките первый узел из очереди
     *         - Проверьте, был ли узел уже посещен, если да, пропустите его
     *         - Если этот узел является тем, который мы ищем, то поиск завершен
     *         - В противном случае добавьте его к посещенным узлам
     *         - Добавьте дочерние элементы этого узла в очередь и повторите эти шаги
     *
     */



    public static void bfs(Map<String, LinkedList<String>> map, String start){
        Deque<Person> queue = new ArrayDeque<>();
        Person startPerson = new Person(start);
        startPerson.history.add(start);
        queue.add(startPerson);
        ArrayList<String> searched = new ArrayList<>();
        while (!queue.isEmpty()){
            Person person = queue.poll();
            String name = person.name;
//            System.out.println(name);
//            System.out.println("     " + person.history);
            if(!searched.contains(name)){
                if(isSeller(name)){
                    System.out.println(" Ta-da!");
                    System.out.println(person.history);
                    return;
                } else {
                    LinkedList<String> list = map.get(name);
                    if(list != null){
                        for (String s : list) {
                            Person p = new Person(s);
                            p.history.addAll(person.history);
                            p.history.add(s);
                            queue.add(p);
                        }
                    }
                }
                searched.add(name);
            }
        }
    }

    public static boolean isSeller(String name){
        return name.equals("jonny");
    }

    public static class Person{
        public String name;
        public ArrayList<String> history;

        public Person(String name) {
            this.name = name;
            history = new ArrayList<>();
        }
    }

}
