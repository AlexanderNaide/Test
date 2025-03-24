package com.test.file_reder;

import java.io.*;
import java.util.Scanner;

public class ScannerFileReader {
    public static void main(String[] args) throws FileNotFoundException {

        String url = "text.txt";

        try(Scanner scanner = new Scanner(new File(url))) {

            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
