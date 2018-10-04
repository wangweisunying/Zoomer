/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomer_quickproject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.DataBaseCon;
import model.ExcelOperation;
import model.Math_Tool;
import model.V7DataBaseCon;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Wei Wang
 */
public class Zoomer_QuickProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        Zoomer_QuickProject test = new Zoomer_QuickProject(new CornZoomer(), "corn_run_23");
        test.init();
        test.getData();
        test.exportExcel();
    }
    private Map<String, Map<String, Float>> map_unit;
    private Map<String, Map<String, List<Float>>> map_raw;
    private Map<String, String[]> loc_sample_map; // test_name , pillarId ,julien Barcode
    private String[] test_code;
    private String table_name , test_name;
    private Condition[] conditions;
    
    private Zoomer_QuickProject(Zoomer test, String table_name) {
        this.test_name = test.test_name;
        this.test_code = test.testcode;
        this.conditions = test.conditions;
        this.table_name = table_name;

        map_unit = new LinkedHashMap();
        map_raw = new HashMap();
        loc_sample_map = new HashMap();
    }
    
    private void exportExcel() throws IOException{
        Workbook wb = ExcelOperation.getWriteConnection(ExcelOperation.ExcelType.XLSX);
        Sheet sheet = wb.createSheet(test_name);
        
        
        HashMap<String , int[] > align_map = new HashMap();
        for(String location : loc_sample_map.keySet()){
            String pillarId = loc_sample_map.get(location)[0];            
            if(!align_map.containsKey(pillarId)){
                align_map.put(pillarId ,new int[]{(test_code.length + 15) * align_map.size() , 3});
            }
        }
        
        for(String pillarId : align_map.keySet()){
            int row = align_map.get(pillarId)[0];
            int col = align_map.get(pillarId)[1];
            sheet.createRow(row ++).createCell(col - 1).setCellValue(pillarId);
            sheet.createRow(row ++).createCell(col - 1).setCellValue("julienBarcode");
            for(String test : map_unit.keySet()){
                sheet.createRow(row ++).createCell(col - 1).setCellValue(test);
            }
        }
        
        
        
        
        for(String location : loc_sample_map.keySet()){
            String pillarId = loc_sample_map.get(location)[0];
            String sample = loc_sample_map.get(location)[1];
            
            
            int row_index = 0 , col_index= 0;
            if(align_map.containsKey(pillarId)){
                row_index = align_map.get(pillarId)[0];
                col_index = align_map.get(pillarId)[1];
                align_map.get(pillarId)[1]++;
            }
            else{
                row_index = (test_code.length + 15) * align_map.size() ;
                col_index = 3;
                align_map.put(pillarId ,new int[]{row_index , col_index + 1});
            }
            
            sheet.getRow(row_index++).createCell(col_index).setCellValue(location);
            sheet.getRow(row_index++).createCell(col_index).setCellValue(sample);
            for(String test : map_unit.keySet()){
                float unit = map_unit.get(test).get(location);
                sheet.getRow(row_index++).createCell(col_index).setCellValue(unit);
            }

        }
        ExcelOperation.writeExcel("C:\\Users\\Wei Wang\\Desktop\\Zoomer\\outPut\\"+ table_name + "_"+ test_name +".xlsx", wb);
    
    }
    
    
    private void getData() throws SQLException {

        DataBaseCon db = new V7DataBaseCon();
        String sql = "SELECT * FROM combine_tables." + table_name + ";";
        ResultSet rs = db.read(sql);
        while (rs.next()) {
            String class_name = rs.getString("class");
            String protein_name = rs.getString("protein_name");
            String info_id = rs.getString("info_id");

            List<Integer> testId_list = new ArrayList();
            for (int i = 0; i < conditions.length; i++) {
                String[] class_cur = conditions[i].class_name.split(",");
                String[] protein_cur = conditions[i].protein_name.split(",");
                String[] info_id_cur = conditions[i].info_id.split(",");
                if (judge(class_cur, protein_cur, info_id_cur, class_name, protein_name, info_id)) {
                    testId_list.add(i);
                    testId_list.add(i + conditions.length);
                    int col_ct = rs.getMetaData().getColumnCount();
                    for (int j = 14; j <= col_ct; j++) {
                        float signal = rs.getFloat(j);
                        String[] location_type = rs.getMetaData().getColumnName(j).split("_");
                        String location = location_type[1];
                        int type = location_type[2].equals("igg") ? 0 : 1;
                        map_raw.get(test_code[testId_list.get(type)]).get(location).add(signal);
                        

                    }

                }

            }

        }

        for (String test : map_raw.keySet()) {
            for (String location : map_raw.get(test).keySet()) {
                List<Float> list = map_raw.get(test).get(location);
                float median = Math_Tool.findMedian(list);
                map_unit.get(test).put(location , median);
            }
        }
    }

    private boolean judge(String[] class_cur, String[] protein_cur, String[] info_id_cur,
            String class_name, String protein_name, String info_id) {
        boolean res_class = false;
        for (String tmp_class : class_cur) {
            if (tmp_class.length() == 0) {
                res_class = true;
                break;
            } else {
                res_class |= class_name.toLowerCase().contains(tmp_class);
            }
        }
        boolean res_protein = false;
        for (String tmp_protein : protein_cur) {
            if (tmp_protein.length() == 0) {
                res_protein = true;
                break;
            } else {
                res_protein |= protein_name.toLowerCase().contains(tmp_protein);
            }
        }
        boolean res_info_id = false;
        for (String tmp_info_id : info_id_cur) {
            if (tmp_info_id.length() == 0) {
                res_info_id = true;
                break;
            } else {
                res_info_id |= info_id.toLowerCase().contains(tmp_info_id);
            }
        }
//        System.out.println(res_class && res_protein && res_info_id);
        return res_class && res_protein && res_info_id;
    }

    // key : location  value : [ pillar_id , julien  ]
    private void init() throws SQLException {
        
        DataBaseCon db = new V7DataBaseCon();

        String sql = "select location , julien_barcode ,pillarId from\n"
                + "(select well_plate_id , location , pillarId from \n"
                + "(SELECT DISTINCT\n"
                + "        (SUBSTRING_INDEX(SUBSTRING_INDEX(COLUMN_NAME, '_', - 2), '_', 1)) AS location , SUBSTRING_INDEX(COLUMN_NAME, '_', 1) as pillarId\n"
                + "    FROM\n"
                + "        information_schema.columns\n"
                + "    WHERE\n"
                + "        TABLE_SCHEMA = 'combine_tables'\n"
                + "            AND TABLE_NAME = '" + table_name + "'\n"
                + "            AND length(COLUMN_NAME) > 16) as a join vibrant_test_tracking.pillar_plate_info as b on \n"
                + "            a.pillarId = b.pillar_plate_id) as d join vibrant_test_tracking.well_info as e \n"
                + "            on d.well_plate_id = e.well_plate_id and d.location = concat(e.well_row , e.well_col);";
        System.out.println(sql);
        ResultSet rs = db.read(sql);
        while (rs.next()) {
            loc_sample_map.put(rs.getString(1), new String[]{rs.getString(3), rs.getString(2)});
        }
        db.close();

        for (String test : test_code) {
            Map<String, Float> loc_unit_map = new HashMap();
            Map<String, List<Float>> loc_raw_map = new HashMap();
            for (String location : loc_sample_map.keySet()) {
                
                loc_unit_map.put(location, -1.0f);
                loc_raw_map.put(location, new ArrayList());
                
            }
            map_unit.put(test, loc_unit_map);
            map_raw.put(test, loc_raw_map);
        }
//        System.out.println(loc_sample_map);
        
        
    }

}
