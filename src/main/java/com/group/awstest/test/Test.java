package com.group.awstest.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

  public void writeExcel() throws IOException {
    Workbook workbook = new SXSSFWorkbook();

    Sheet sheet = workbook.createSheet("Person");
    sheet.setColumnWidth(0, 6000);
    sheet.setColumnWidth(1, 4000);

    Row header = sheet.createRow(0);

    CellStyle headerStyle = workbook.createCellStyle();
// 생략

    XSSFFont font = ((XSSFWorkbook) workbook).createFont();
// 생략

    Cell headerCell = header.createCell(0);
    headerCell.setCellValue("Name");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(1);
    headerCell.setCellValue("Age");
    headerCell.setCellStyle(headerStyle);

// Next, let's write the content of the table with a different style:
    CellStyle style = workbook.createCellStyle();
    style.setWrapText(true);

    Row row = sheet.createRow(2);
    Cell cell = row.createCell(0);
    cell.setCellValue("John Smith");
    cell.setCellStyle(style);

    cell = row.createCell(1);
    cell.setCellValue(20);
    cell.setCellStyle(style);

    File currDir = new File("C:\\Users\\우시은\\Desktop\\식품영양성분DB\\.");
    String path = currDir.getAbsolutePath();
    String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

    FileOutputStream outputStream = new FileOutputStream(fileLocation);
    workbook.write(outputStream);
    workbook.close();

  }

}
