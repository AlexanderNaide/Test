package com.yandex;

import java.util.*;

public class task4 {
    public static void main(String[] args) {
        /**
         * —группировать слова по общим буквам
         * Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"]
         * Sample Output [[ate, eat, tea], [nat, tan], [bat]]
         */

        List<String> words = new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));

        Collection<List<String>> sortedWords = groupWords(words);

        System.out.println(sortedWords);

    }

    private static Collection <List<String>> groupWords(List<String> words){
        Map<String, List<String>> wordsMap = new HashMap<>();
        for (String word : words) {
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String key = new String(charWord);
            if (wordsMap.containsKey(key)){
                wordsMap.get(key).add(word);
            } else {
                wordsMap.put(key, new ArrayList<>(List.of(word)));
            }
        }
        return wordsMap.values();
    }
}
