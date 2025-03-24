package com.test.file_reder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleBufferedReader {
    public static void main(String[] args) throws FileNotFoundException {

        String url = "text.txt";

        try(BufferedReader bufferedReaderReader = new BufferedReader(new FileReader(url))) {

            String line = bufferedReaderReader.readLine();
            while (line != null){
                System.out.println(line);
                line = bufferedReaderReader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
