package com.example.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static final String testDataExcelFileName = "testdata.xlsx"; //Global test data excel file
    public static final String currentDir = System.getProperty("user.dir");  //Main Directory of the project
    public static final String resourcePath = "\\src\\test\\resources\\";  //Main Directory of the project
    public static String testDataExcelPath = null; //Location of Test data excel file
    private static XSSFWorkbook excelWorkBook; //Excel WorkBook
    private static XSSFSheet excelWorkSheet; //Excel Sheet
    private static XSSFCell cell; //Excel cell
    private static XSSFRow row; //Excel row
    public static int rowNumber; //Row Number
    public static int columnNumber; //Column Number
    public static FileInputStream ExcelFile;

    public static DataFormatter formatter;
    public static FileOutputStream fileOut;


    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    public static void setExcelFileSheet(String sheetName) throws IOException {

        testDataExcelPath = currentDir + resourcePath;

        // Open the Excel file
        ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWorkBook = new XSSFWorkbook(ExcelFile);
        excelWorkSheet = excelWorkBook.getSheet(sheetName);

    }

    //This method reads the test data from the Excel cell.
    public static String getCellData(int rowNum, int colNum) {
        cell = excelWorkSheet.getRow(rowNum).getCell(colNum);
        formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int rowNum) {
        row = excelWorkSheet.getRow(rowNum);
        return row;
    }

    //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData(String value, int rowNum, int colNum) throws IOException {
        row = excelWorkSheet.getRow(rowNum);
        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }

        // Write to the workbook
        fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
        excelWorkBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}