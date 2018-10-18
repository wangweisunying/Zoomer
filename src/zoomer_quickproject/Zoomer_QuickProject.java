/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomer_quickproject;

import Zoomer.Condition;
import Zoomer.CornZoomer;
import Zoomer.DairyZoomer;
import Zoomer.EggZoomer;
import Zoomer.LectinZoomer;
import Zoomer.PeanutZoomer;
import Zoomer.Zoomer;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import model.DataBaseCon;
import model.ExcelOperation;
import model.LXDataBaseCon;
import model.Math_Tool;
import model.V7DataBaseCon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;

/**
 *
 * @author Wei Wang
 */
public class Zoomer_QuickProject {

    /**
     * @param args the command line arguments
     */
    private static String path = "C:\\Users\\Wei Wang\\Desktop\\Zoomer\\outPut";

    public static void main(String[] args) throws SQLException, IOException, Exception {
//        ZOOMER_TEST[] test = {ZOOMER_TEST.DAIRY_ZOOMER};
//        String[] table = {"dairy_run_23"};
        ZOOMER_TEST[] test = {ZOOMER_TEST.CORN_ZOOMER, ZOOMER_TEST.DAIRY_ZOOMER, ZOOMER_TEST.EGG_ZOOMER, ZOOMER_TEST.LECTIN_ZOOMER, ZOOMER_TEST.PEANUT_ZOOMER};
        String[] table = {"corn_run_23", "dairy_run_23", "egg_run_23", "lectin_run_23", "peanut_run_23"};

//      
        List<Chunk> list = new ArrayList();
        for (int i = 0; i < test.length; i++) {
            list.add(run(table[i], test[i]));
        }
        exportExcel(list);
    }

    private static class Chunk {

        private String testName , tableName;
        private Map<String, Map<String, Float>> map_unit;
        private String[] test_code;
        private Map<String, String[]> loc_sample_map;

        private Chunk(String tableName ,String testName, String[] test_code, Map<String, String[]> loc_sample_map, Map<String, Map<String, Float>> map_unit) {
            this.tableName = tableName;
            this.testName = testName;
            this.test_code = test_code;
            this.loc_sample_map = loc_sample_map;
            this.map_unit = map_unit;
        }

    }

    private static enum ZOOMER_TEST {
        CORN_ZOOMER,
        DAIRY_ZOOMER,
        LECTIN_ZOOMER,
        PEANUT_ZOOMER,
        EGG_ZOOMER
    }

    private static Map<String, Map<String, Float>> map_unit;
    private static Map<String, String[]> loc_sample_map; // test_name , pillarId ,julien Barcode
    private static String[] test_code;
    private static String table_name, test_name;
    private Map<String, Map<String, List<Float>>> map_raw;
    private Condition[] conditions;
    private Map<String, List<Float>> negative_map;  // location  , raw data
    private Map< String, double[]> equation_parameter_map; // String [a , b]

    private Set<String> exclude_set;

    private Zoomer_QuickProject(Zoomer test, String table_name) {
        this.test_name = test.getTestName();
        this.test_code = test.getTestCode();
        this.conditions = test.getCondition();
        this.equation_parameter_map = test.getEquationParameterMap();

        this.table_name = table_name;

        this.map_unit = new LinkedHashMap();
        this.map_raw = new HashMap();
        this.loc_sample_map = new HashMap();
        this.negative_map = new HashMap();
        this.exclude_set = new HashSet();
    }

    private static Chunk run(String table_name, ZOOMER_TEST test) throws SQLException {

        Zoomer_QuickProject zoomer_ctroller;
        boolean precheck;
        switch (test) {
            case CORN_ZOOMER:
                precheck = Pattern.matches("corn_run_.*", table_name.toLowerCase());
                zoomer_ctroller = new Zoomer_QuickProject(new CornZoomer(), table_name);
                break;
            case DAIRY_ZOOMER:
                precheck = Pattern.matches("dairy_run_.*", table_name.toLowerCase());
                zoomer_ctroller = new Zoomer_QuickProject(new DairyZoomer(), table_name);
                break;
            case LECTIN_ZOOMER:
                precheck = Pattern.matches("lectin_run_.*", table_name.toLowerCase());
                zoomer_ctroller = new Zoomer_QuickProject(new LectinZoomer(), table_name);
                break;
            case PEANUT_ZOOMER:
                precheck = Pattern.matches("peanut_run_.*", table_name.toLowerCase());
                zoomer_ctroller = new Zoomer_QuickProject(new PeanutZoomer(), table_name);
                break;
            case EGG_ZOOMER:
                precheck = Pattern.matches("egg_run_.*", table_name.toLowerCase());
                zoomer_ctroller = new Zoomer_QuickProject(new EggZoomer(), table_name);
                break;
            default:
                precheck = false;
                zoomer_ctroller = null;
                System.out.println("excel format input is wrong!!");
                break;
        }
        if (zoomer_ctroller == null) {
            System.out.println("testZoomer type input is wrong!");
            return null;
        }
        if (!precheck) {
            System.out.println(" table_name input format is wrong! or is not match the test you select !");
            return null;

        }

        zoomer_ctroller.init();
        zoomer_ctroller.getData();
        return new Chunk(table_name ,test_name, test_code, loc_sample_map, map_unit);

//            zoomer_ctroller.exportExcel();
//            OpenLocalFile opener = new OpenLocalFile();
//            opener.open(path + "\\" + table_name + "_" + test_name + ".xlsx");
    }

    private static void exportExcel(List<Chunk> list) throws IOException, Exception {
        Workbook wb = ExcelOperation.getWriteConnection(ExcelOperation.ExcelType.XLSX);
       
        for (Chunk chunk : list) {
            
            String tableName = chunk.tableName;
            String test_name = chunk.testName;
//            System.out.println(tableName + ":" +test_name + Arrays.toString(chunk.test_code) );
            Map<String, Map<String, Float>> map_unit = chunk.map_unit;
            String[] test_code = chunk.test_code;
            Map<String, String[]> loc_sample_map = chunk.loc_sample_map;
            
            //get the dup data
            ChunkDupData chunkDup = getDup(loc_sample_map , test_name);
            
            
            
            Sheet sheet = wb.createSheet(tableName);
            int row = test_code.length + 30, col = 0;
            sheet.createRow(row++).createCell(col).setCellValue("CF");
            sheet.createRow(row++).createCell(col).setCellValue("Pillar_Id");
            sheet.createRow(row++).createCell(col).setCellValue("Location");
            sheet.createRow(row++).createCell(col).setCellValue("Julien_Barcode");

            for (String test : map_unit.keySet()) {
                sheet.createRow(row++).createCell(col).setCellValue(test);
            }
            
            
            

            
            col++;
            for (String location : loc_sample_map.keySet()) {
                String pillarId = loc_sample_map.get(location)[0];
                String sample = loc_sample_map.get(location)[1];

                int row_index = test_code.length + 30;
                sheet.getRow(row_index++).createCell(col).setCellValue(1);
                sheet.getRow(row_index++).createCell(col).setCellValue(pillarId);
                sheet.getRow(row_index++).createCell(col).setCellValue(location);
                sheet.getRow(row_index++).createCell(col).setCellValue(sample);

                for (String test : map_unit.keySet()) {
                    float unit = map_unit.get(test).get(location);
                    Cell cell = sheet.getRow(row_index++).createCell(col);
                    cell.setCellValue(unit);
                }
                col++;
            }
            
            row = 0;
            col = 0;
            sheet.createRow(row++).createCell(col).setCellValue("CF");
            sheet.createRow(row++).createCell(col).setCellValue("Pillar_Id");
            sheet.createRow(row++).createCell(col).setCellValue("Location");
            sheet.createRow(row++).createCell(col).setCellValue("Julien_Barcode");

            for (String test : map_unit.keySet()) {
                sheet.createRow(row++).createCell(col).setCellValue(test);
            }
            
            //generate the dup title on row  
            if(chunkDup != null){
                String[] dupTestCodeArr = chunkDup.getDupTestCode();
                row++;
                for(String dupTestCode : dupTestCodeArr){
                    sheet.createRow(row++).createCell(col).setCellValue(dupTestCode);
                }            
            }
            
            
            
            
            
            
            col++;
            for (String location : loc_sample_map.keySet()) {
                String pillarId = loc_sample_map.get(location)[0];
                String sample = loc_sample_map.get(location)[1];

                int row_index = 0;
                sheet.getRow(row_index++).createCell(col).setCellValue(1);
                sheet.getRow(row_index++).createCell(col).setCellValue(pillarId);
                sheet.getRow(row_index++).createCell(col).setCellValue(location);
                sheet.getRow(row_index++).createCell(col).setCellValue(sample);
                         
                for (int i = 0; i < test_code.length; i++) {
                    Cell cell = sheet.getRow(row_index++).createCell(col);
                    cell.setCellType(CellType.FORMULA);
                    String rowAxis = ExcelOperation.transferIntgerToString(col + 1);
                    String formula = rowAxis + "" + (row_index + test_code.length + 30);
                    String cfCell = rowAxis + "1";
                    cell.setCellFormula(formula + "/" + cfCell);

                }
                
                if(chunkDup != null){
                    Map<String , int[]> dupUnitMap = chunkDup.getJulienUnitMap();
                    row_index++;
                    int[] dupUnit = dupUnitMap.get(sample);
                    for(int i = 0 ; i < dupUnit.length ; i++){
                        sheet.getRow(row_index++).createCell(col).setCellValue(dupUnit[i]);
                    }
                }
            
                
                
                
                
                col++;
            }
            
            //set the condition format
            String range = "B5:" + ExcelOperation.transferIntgerToString(loc_sample_map.size() + 1) + (4 + test_code.length);
            System.out.println(range);
            ExcelOperation.setConditionalFormatting(sheet, IndexedColors.RED, ComparisonOperator.GT, new String[]{"4"}, range);
            ExcelOperation.setConditionalFormatting(sheet, IndexedColors.YELLOW, ComparisonOperator.BETWEEN, new String[]{"2" , "4"}, range);
            ExcelOperation.setConditionalFormatting(sheet, IndexedColors.GREEN, ComparisonOperator.LT, new String[]{"2"}, range);
        }

        wb.setForceFormulaRecalculation(true);
        
        String pattern = "yyyyMMddHHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        
        //evaluate format
        XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
        ExcelOperation.writeExcel(path + "\\" + "ZOOMER_" + date + ".xlsx", wb);
        
    }

    private void getData() throws SQLException {

        DataBaseCon db = new V7DataBaseCon();
        String sql = "SELECT * FROM combine_tables." + table_name + ";";
        ResultSet rs = db.read(sql);
        while (rs.next()) {
            String class_name = rs.getString("class");
            String protein_name = rs.getString("protein_name");
            String info_id = rs.getString("info_id");
            String seq = rs.getString("sequence");

            //init neg
            if (class_name.toLowerCase().contains("neg")) {
                int col_ct = rs.getMetaData().getColumnCount();
                for (int j = 14; j <= col_ct; j++) {
                    float signal = rs.getFloat(j);
                    String[] location_type = rs.getMetaData().getColumnName(j).split("_");
                    String location = location_type[1];
                    String type = location_type[2];
                    String key = location + "_" + type;

                    if (exclude_set.contains(location)) {
                        continue;
                    }

                    if (negative_map.containsKey(key)) {
                        negative_map.get(key).add(signal);
                    } else {
                        negative_map.put(key, new ArrayList(Arrays.asList(signal)));
                    }
                }
            }

            // init raw
            for (int i = 0; i < conditions.length; i++) {
                String[] class_cur = conditions[i].getClassName().split("%");
                String[] protein_cur = conditions[i].getProteinName().split("%");
                String[] info_id_cur = conditions[i].getInfoId().split("%");
                String[] seq_cur = conditions[i].getSeq().split("%");
                if (judge(class_cur, protein_cur, info_id_cur, seq_cur, class_name, protein_name, info_id, seq)) {
                    List<Integer> testId_list = new ArrayList();
                    testId_list.add(i);//igg
                    testId_list.add(i + conditions.length); //iga
                    int col_ct = rs.getMetaData().getColumnCount();
                    for (int j = 14; j <= col_ct; j++) {
                        float signal = rs.getFloat(j);
                        String[] location_type = rs.getMetaData().getColumnName(j).split("_");
                        String location = location_type[1];
                        if (exclude_set.contains(location)) {
                            continue;
                        }

                        int type = location_type[2].equals("igg") ? 0 : 1;
                        map_raw.get(test_code[testId_list.get(type)]).get(location).add(signal);

                    }

                }

            }

        }

//        System.out.println(map_raw.get("CORN_ALBUMIN_IGG").get("f3").size());
//        for(float x : map_raw.get("CORN_ALBUMIN_IGG").get("f3")){
//            System.out.println(x);
//        }
        for (String test : map_raw.keySet()) {
            for (String location : map_raw.get(test).keySet()) {
                List<Float> list = map_raw.get(test).get(location);
//                float median_raw = Math_Tool.findMedian(list);
//                float median_neg = Math_Tool.findMedian(negative_map.get(location));
//                float unit = median_raw * 3000 / median_neg ;
//                map_unit.get(test).put(location , unit);

                String type = test.substring(test.lastIndexOf("_") + 1).toLowerCase();
                float avg_raw = Math_Tool.avg(list);
                float avg_neg = Math_Tool.avg(negative_map.get(location + "_" + type));
                float unit = avg_raw * 3000 / avg_neg;

                //apply equation
                double[] para = equation_parameter_map.get(test);
                unit = (float) (unit * para[0] + para[1]);

                map_unit.get(test).put(location, unit);
            }
        }
    }

    private boolean judge(String[] class_cur, String[] protein_cur, String[] info_id_cur, String[] seq_cur,
            String class_name, String protein_name, String info_id, String seq) {
        boolean res_class = false;
        for (String tmp_class : class_cur) {
            if (tmp_class.length() == 0) {
                res_class = true;
                break;
            } else {
                res_class |= Pattern.matches(tmp_class.toLowerCase(), class_name.toLowerCase());
            }
        }
        boolean res_protein = false;
        for (String tmp_protein : protein_cur) {
            if (tmp_protein.length() == 0) {
                res_protein = true;
                break;
            } else {
                res_protein |= Pattern.matches(tmp_protein.toLowerCase(), protein_name.toLowerCase());
            }
        }
        boolean res_info_id = false;
        for (String tmp_info_id : info_id_cur) {
            if (tmp_info_id.length() == 0) {
                res_info_id = true;
                break;
            } else {
                res_info_id |= Pattern.matches(tmp_info_id.toLowerCase(), info_id.toLowerCase());
            }
        }
        boolean res_seq = false;
        for (String tmp_seq : seq_cur) {
            if (tmp_seq.length() == 0) {
                res_seq = true;
                break;
            } else {
                res_seq |= Pattern.matches(tmp_seq.toLowerCase(), seq.toLowerCase());
            }
        }
//        System.out.println(res_class && res_protein && res_info_id);
        return res_class && res_protein && res_info_id && res_seq;
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
            String sample = rs.getString(2).toLowerCase();
            String location = rs.getString(1);
            if (sample.matches(".*[a-z].*")) {
                exclude_set.add(location);
                continue;
            }

            loc_sample_map.put(location, new String[]{rs.getString(3), sample});
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
    
    private static ChunkDupData getDup(Map<String, String[]> locationMap , String testName) throws SQLException{
        Map<String , int[]> map = new HashMap();
        
        StringBuilder sb = new StringBuilder();
        for(String location : locationMap.keySet()){
            sb.append(locationMap.get(location)[1] + ",");
        }
        
        String julienString = sb.substring(0, sb.length() - 1).toString();
        String sql = "";
        if(testName.equals("Corn")){
            sql = "select julien_barcode,corn_igg,corn_iga\n" +
"from  vibrant_america_information.`sample_data` sd \n" +
"left join `vibrant_america_test_result`.`result_wellness_panel19` rwp2 on sd.`sample_id` = rwp2.`sample_id`\n" +
"left join `vibrant_america_test_result`.`result_wellness_panel18` rwp1 ON rwp1.`sample_id` = sd.`sample_id` \n" +
"where julien_barcode in ("+ julienString +");";
        }
        else if(testName.equals("Egg")){
            sql = "select julien_barcode,egg_white_igg,egg_white_iga,egg_yolk_igg,egg_yolk_iga\n" +
"from  vibrant_america_information.`sample_data` sd \n" +
"left join `vibrant_america_test_result`.`result_wellness_panel19` rwp2 on sd.`sample_id` = rwp2.`sample_id`\n" +
"left join `vibrant_america_test_result`.`result_wellness_panel18` rwp1 ON rwp1.`sample_id` = sd.`sample_id` \n" +
"where julien_barcode in \n" +
"("+ julienString +") ;";
        }
        else if(testName.equals("Dairy")){
            sql = "select julien_barcode,BETA_CAS_IGG,BETA_CAS_IGa,CASOMORP_IGG,CASOMORP_IGa,COWS_MILK_IGG,COWS_MILK_IGa,GOATS_MILK_IGG,GOATS_MILK_IGa,WHEY_PROTE_IGG,WHEY_PROTE_IGa \n" +
"from  vibrant_america_information.`sample_data` sd\n" +
"left join `vibrant_america_test_result`.`result_wellness_panel16` rwp1 ON rwp1.`sample_id` = sd.`sample_id`\n" +
"where julien_barcode in ("+ julienString +");";
        }
        else if(testName.equals("Peanut")){
            sql = "select julien_barcode,peanut_igg,peanut_iga\n" +
"from  vibrant_america_information.`sample_data` sd \n" +
"left join `vibrant_america_test_result`.`result_wellness_panel19` rwp2 on sd.`sample_id` = rwp2.`sample_id`\n" +
"left join `vibrant_america_test_result`.`result_wellness_panel18` rwp1 ON rwp1.`sample_id` = sd.`sample_id` \n" +
"where julien_barcode in ("+ julienString +") ;";
        }
        else{
            return null;
        } 
                
        DataBaseCon db = new LXDataBaseCon();
        ResultSet rs = db.read(sql);
        int ct = rs.getMetaData().getColumnCount();
        
        String[] dupTestCode = new String[ct - 1];
        for(int i = 0 ; i < ct - 1 ; i++){
            dupTestCode[i] = rs.getMetaData().getColumnLabel(i + 2);
        }
        
        while(rs.next()){
            int[] dupUnitArr = new int[ct - 1];
            for(int i = 0 ; i < ct - 1 ; i++){
                dupUnitArr[i] = rs.getObject(i + 2) == null ? - 1 : rs.getInt(i + 2);
            }          
            map.put(rs.getString(1), dupUnitArr);
        }
        db.close();
        return new ChunkDupData(map , dupTestCode);
    }
    
    
    private static class ChunkDupData{
         private Map<String , int[]> julienUnitMap;
         private String[] dupTestCode;
         
         public ChunkDupData(Map<String , int[]> julienUnitMap, String[] dupTestCode){
             this.julienUnitMap = julienUnitMap;
             this.dupTestCode = dupTestCode;
         }
         
         public Map<String , int[]> getJulienUnitMap(){
             return this.julienUnitMap;
         }
         
         public String[] getDupTestCode(){
             return this.dupTestCode;
         }
         
         
    
    
    }
    

}
