/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomer_quickproject;

import Zoomer.CornZoomer;
import Zoomer.DairyZoomer;
import Zoomer.EggZoomer;
import Zoomer.LectinZoomer;
import Zoomer.NeuralZoomer;
import Zoomer.NutZoomer;
import Zoomer.PeanutZoomer;
import Zoomer.SoyZoomer;
import Zoomer.Zoomer_Unit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
    private static String path = "C:\\Users\\Wei Wang\\Desktop\\Zoomer\\outPut\\ZOOMER_20181219114438.xlsx";

    public static void main(String[] args) throws IOException, SQLException, Exception {
        RUN(path);
    }

    public static void RUN(String fileName) throws IOException, SQLException, Exception {
        Workbook wb = ExcelOperation.getReadConnection(path, ExcelOperation.ExcelType.XLSX);
        int ct = wb.getNumberOfSheets();
        List<List<Zoomer_Unit>> wholeList = new ArrayList();

        for (int i = 0; i < ct; i++) {
            Sheet sheet = wb.getSheetAt(i);
            if(wb.getSheetName(i).equals("ref_sheet")){
                continue;
            }

            List<Zoomer_Unit> list = new ArrayList();
            int rowct = 5, colct = 1;
            //insert into `tsp_test_unit_data`.`zoomers_unit_data` values ('CORN_ALBUMIN_IGG','1809190213','0.964987944825308','TST2847T22847N11','D','1',0,now());
            Row pillar_row = sheet.getRow(2);
            Row location_row = sheet.getRow(3);
            Row juilen_row = sheet.getRow(4);
            while (sheet.getRow(rowct) != null) {
                Row row = sheet.getRow(rowct);
                String test = row.getCell(0).getStringCellValue();
                while (row.getCell(colct) != null) {
                    String location = location_row.getCell(colct).getStringCellValue();
                    pillar_row.getCell(colct).getStringCellValue();
                    list.add(new Zoomer_Unit(sheet.getSheetName().split("_")[0], test, juilen_row.getCell(colct).getStringCellValue(), row.getCell(colct).getNumericCellValue(), pillar_row.getCell(colct).getStringCellValue(),
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
            HashSet<String> pillarId_set = new HashSet();

            for (Zoomer_Unit unit : list) {
                pillarId_set.add(unit.getPillarId());
                String sql = "insert into `tsp_test_unit_data`.`zoomers_unit_data` values ('" + unit.getTestCode() + "','" + unit.getJulienBarcode() + "','" + unit.getUnit()
                        + "','" + unit.getPillarId() + "','" + unit.getRow() + "','" + unit.getCol() + "',0,now()) on duplicate key update unit = '" + unit.getUnit() + "';";

                db.write(sql);
                System.out.println(sql);
            }
            String testName = list.get(0).getTestName();
            float[] arr = new float[]{-1f};
            if (testName.equals("corn")) {
                arr = CornZoomer.getQcArr();
            }
            if (testName.equals("egg")) {
                arr = EggZoomer.getQcArr();
            }
            if (testName.equals("lectin")) {
                arr = LectinZoomer.getQcArr();
            }
            if (testName.equals("peanut")) {
                arr = PeanutZoomer.getQcArr();
            }
            if (testName.equals("dairy")) {
                arr = DairyZoomer.getQcArr();
            }
            if (testName.equals("nut")) {
                arr = NutZoomer.getQcArr();
            }
            if (testName.equals("soy")) {
                arr = SoyZoomer.getQcArr();
            }
            if (testName.equals("neural")) {
                arr = NeuralZoomer.getQcArr();
            }
            if (arr.length != 3) {
                throw new Exception("this Qc arr is not valid!");
            }

            for (String pillarId : pillarId_set) {
                String sqlUpdate = "UPDATE `vibrant_test_tracking`.`pillar_plate_info` SET `status`='finish' WHERE `pillar_plate_id`='" + pillarId + "'";

                db.write(sqlUpdate);
                System.out.println(sqlUpdate);
                sqlUpdate = "INSERT INTO `tsp_test_qc_data`.`test_qc_data` (`test_name`, `pillar_plate_id`, `cal_1`, `pos_ctrl_1`, `neg_ctrl_1`,`time`) VALUES ('" + testName
                        + "_qc', '" + pillarId + "', '" + arr[0] + "', '" + arr[1] + "', '" + arr[2] + "',now());";
                
                db.write(sqlUpdate);
                System.out.println(sqlUpdate);
            }

        }
        db.close ();
        System.out.println ("DB inserted sucessfully!");

        

    

    }

}
