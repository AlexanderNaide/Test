package com.test.file_reder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PathFileReader {
    public static void main(String[] args) throws FileNotFoundException {

        String url = "text.txt";

        try {

            List<String> lines = Files.readAllLines(Path.of(url));

            lines.forEach(System.out::println);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
