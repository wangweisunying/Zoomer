/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomer_quickproject;

import Zoomer.Zoomer_Unit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DataBaseCon;
import model.ExcelOperation;
import model.V7DataBaseCon;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Wei Wang
 */
public class Zoomer_toDB {

    /**
     * @param args the command line arguments
     */
    private static String path = "C:\\Users\\Wei Wang\\Desktop\\Zoomer\\outPut\\ZOOMER_20181016143738.xlsx";

    public static void main(String[] args) throws IOException, SQLException {
        RUN(path);
    }

    public static void RUN(String fileName) throws IOException, SQLException {
        Workbook wb = ExcelOperation.getReadConnection(path, ExcelOperation.ExcelType.XLSX);
        int ct = wb.getNumberOfSheets();
        List<List<Zoomer_Unit>> wholeList = new ArrayList();

        for (int i = 0; i < ct; i++) {
            Sheet sheet = wb.getSheetAt(i);
            List<Zoomer_Unit> list = new ArrayList();
            int rowct = 4, colct = 1;
            //insert into `tsp_test_unit_data`.`zoomers_unit_data` values ('CORN_ALBUMIN_IGG','1809190213','0.964987944825308','TST2847T22847N11','D','1',0,now());
            Row pillar_row = sheet.getRow(1);
            Row location_row = sheet.getRow(2);
            Row juilen_row = sheet.getRow(3);
            while (sheet.getRow(rowct) != null) {
                Row row = sheet.getRow(rowct);
                String test = row.getCell(0).getStringCellValue();
                while (row.getCell(colct) != null) {
                    String location = location_row.getCell(colct).getStringCellValue();
                    list.add(new Zoomer_Unit(test, juilen_row.getCell(colct).getStringCellValue(), row.getCell(colct).getNumericCellValue(), pillar_row.getCell(colct).getStringCellValue(),
                            location.substring(0, 1), location.substring(1)));
//                    System.out.println(rowct + " : " + colct + "  " + row.getCell(colct).getNumericCellValue());
                    row.getCell(colct).getNumericCellValue();

                    colct++;
                }

                colct = 1;
                rowct++;
            }
//            System.out.println(list.size());
            wholeList.add(list);

            wb.close();
        }

      
        DataBaseCon db = new V7DataBaseCon();
        for (List<Zoomer_Unit> list : wholeList) {
            for (Zoomer_Unit unit : list) {
                String sql = "insert into `tsp_test_unit_data`.`zoomers_unit_data` values ('" + unit.getTestCode() + "','" + unit.getJulienBarcode() + "','" + unit.getUnit()
                        + "','" + unit.getPillarId() + "','" + unit.getRow() + "','" + unit.getCol() + "',0,now()) on duplicate key update unit = '"+ unit.getUnit() +"';";
               
                db.write(sql);
                System.out.println(sql);
            }
        }
        db.close();
        System.out.println("DB inserted sucessfully!");

    }

}
