package org.example.configaration.utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadFromExcel {

    public static void main(String[] args) throws IOException {
        String filetPath = "../BDD_Rest_API_Automation_FrameWork/DataTest/Data.xlsx";
        String excelPath = "./DataTest/Book.xlsx";
        readExcelFile(filetPath,0);
//        readExcelFile(filetPath,0);
        readExcelFile1(filetPath,0);
        getRowCount(excelPath,0);
        getCellValue(excelPath,"Sheet1",0,1);
    }


    public static void getRowCount(String filePath, int sheetIndex) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

//        String value = sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println("No of Rows: "+rowCount);

    }
    public static void getCellValue(String filePath, String sheetName,int rowIndex,int cellIndex) throws IOException {
         XSSFWorkbook workbook = new XSSFWorkbook(filePath);
         XSSFSheet sheet = workbook.getSheet(sheetName);
         DataFormatter formatter = new DataFormatter();
         Object value = formatter.formatCellValue(sheet.getRow(rowIndex).getCell(cellIndex));
//        String value0 = sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
//        String value2 = sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println("Row 0 Value : "+ value);
//        System.out.println("Row 1 Value : "+ value2);

    }


    public static void readExcelFile(String filePath, int sheetNumber) {
        Workbook workbook;
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            Sheet dataTypeSheet = workbook.getSheetAt(sheetNumber);

            Iterator<Row> rowIterator = dataTypeSheet.iterator();
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();

                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "         ");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "         ");
                    } else if (currentCell.getCellType() == CellType.BOOLEAN) {
                        System.out.print(currentCell.getBooleanCellValue() + "         ");
                    }
                }
                System.out.println();
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException "+e.getMessage());
        }
    }


    public static void readExcelFile1(String filePath, int sheetNumber) {
        Workbook workbook;
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            Sheet dataTypeSheet = workbook.getSheetAt(sheetNumber);

            for (Row currentRow : dataTypeSheet) {
                for (Cell currentCell : currentRow) {
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "         ");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "         ");
                    } else if (currentCell.getCellType() == CellType.BOOLEAN) {
                        System.out.print(currentCell.getBooleanCellValue() + "         ");
                    }
                }
                System.out.println();
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException "+e.getMessage());
        }


    }

}
