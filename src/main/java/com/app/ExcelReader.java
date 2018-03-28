package com.app;

import org.apache.poi.xssf.usermodel.*;

import java.io.*;

import java.sql.Time;

import java.util.Date;


public class ExcelReader {

    private static final int COUNT_COLUMNS = 4;

    public static void main(String[] args) {

        File file = new File("d:/Java/Tasks/SeleniumTest/src/main/resources/invalid login data.xlsx");

        try(XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {

            XSSFSheet sheet = workbook.getSheet("Лист1");

            for (int r = 0; r <= sheet.getLastRowNum(); r++) {

                XSSFRow row = sheet.getRow(r);

                int number = (int)row.getCell(0).getNumericCellValue();

                String text = row.getCell(1).getStringCellValue();

                double dNumber = row.getCell(2).getNumericCellValue();

                Date date = row.getCell(3).getDateCellValue();

                Time time = new Time(row.getCell(4).getDateCellValue().getTime());

                int formula = (int)row.getCell(5).getNumericCellValue();


                System.out.println(String.format("%3d| %9s|%7.2f| %s|%s| %d",

                        number, text, dNumber, date, time, formula));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}