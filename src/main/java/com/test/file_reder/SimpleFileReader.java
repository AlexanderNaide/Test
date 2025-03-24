package com.test.file_reder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleFileReader {
    public static void main(String[] args) throws FileNotFoundException {

        SimpleFileReader simpleFileReader = new SimpleFileReader();
        String url = simpleFileReader.getFileUrl();

        try(FileReader fileReader = new FileReader(url)) {

            while (fileReader.ready()){
                System.out.println(fileReader.read());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFileUrl() {
        return "text.txt";
    }
}
