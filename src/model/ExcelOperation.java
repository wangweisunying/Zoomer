/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Wei Wang
 */
public class ExcelOperation {

    public static enum ExcelType {
        XLS,
        XLSX
    }

    public static Workbook getReadConnection(String path, ExcelType type) throws IOException {
        FileInputStream fileIn = new FileInputStream(path);
        Workbook wb;
        switch (type) {
            case XLS:
                wb = new HSSFWorkbook(fileIn);
                break;
            case XLSX:
                wb = new XSSFWorkbook(fileIn);
                break;
            default:
                wb = null;
                System.out.println("excel format input is wrong!!");
                break;
        }
        return wb;
    }

    public static Workbook getWriteConnection(ExcelType type) throws IOException {
        Workbook wb;
        switch (type) {
            case XLS:
                wb = new HSSFWorkbook();
                break;
            case XLSX:
                wb = new XSSFWorkbook();
                break;
            default:
                wb = null;
                System.out.println("excel format input is wrong!!");
                break;
        }
        return wb;

    }

    public static void writeExcel(String path ,Workbook wb ) throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream(path);
        wb.write(fileOut);
        fileOut.close();
        wb.close();
        System.out.println("Your excel file has been generated!");
    }

}
