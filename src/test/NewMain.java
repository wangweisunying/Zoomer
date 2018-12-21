/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import model.ExcelOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;

/**
 *
 * @author Wei Wang
 * 
 * 
 * 
 */




public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Workbook wb = ExcelOperation.getWriteConnection(ExcelOperation.ExcelType.XLSX);
        Sheet sh = wb.createSheet();
        
        Cell cell = sh.createRow(0).createCell(0);
        cell.setCellValue(123);

        
        SheetConditionalFormatting sheetCf = sh.getSheetConditionalFormatting();
        
        ConditionalFormattingRule rule1 = sheetCf.createConditionalFormattingRule(ComparisonOperator.GT, "70");
        PatternFormatting fill1 = rule1.createPatternFormatting();
        fill1.setFillBackgroundColor(IndexedColors.RED.index);
//        fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        
        ConditionalFormattingRule rule2 = sheetCf.createConditionalFormattingRule(ComparisonOperator.LT, "50");
        PatternFormatting fill2 = rule2.createPatternFormatting();
        fill2.setFillBackgroundColor(IndexedColors.GREEN.index);
//        fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        
        ConditionalFormattingRule rule3 = sheetCf.createConditionalFormattingRule(ComparisonOperator.BETWEEN,"50" , "70");
        PatternFormatting fill3 = rule3.createPatternFormatting();
        fill3.setFillBackgroundColor(IndexedColors.YELLOW.index);
//        fill3.setFillPattern(PatternFormatting.);
        
        CellRangeAddress[] regions = {
                CellRangeAddress.valueOf("A1:Z26")
        };
        sheetCf.addConditionalFormatting(regions, rule1);
        sheetCf.addConditionalFormatting(regions, rule2);
        sheetCf.addConditionalFormatting(regions, rule3);
        
                
        ExcelOperation.writeExcel("C:\\Users\\Wei Wang\\Desktop\\Zoomer\\outPut\\123.xlsx", wb);
    }
}
