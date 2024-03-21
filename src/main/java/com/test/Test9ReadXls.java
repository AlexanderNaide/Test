package com.test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Test9ReadXls {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File("/home/alexander/Рабочий стол/test.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(3);
//            System.out.println(row.getCell(0).getCellType());
            Cell c1 = row.getCell(1);
            String text = String.valueOf(c1.getAddress());
            System.out.println(text);
//            Integer integer = Integer.parseInt(text);
//            System.out.println(integer);
            fis.close();


/*            FileInputStream fis2 = new FileInputStream(new File("/home/alexander/Рабочий стол/test.xlsx"));
            XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
            XSSFSheet sheet2 = workbook2.getSheetAt(0);
            Row row2 = sheet2.getRow(0);
            Cell c2 = row2.getCell(0);
            String text2 = c2.getStringCellValue();
            System.out.println(text2);
            fis2.close();*/




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
