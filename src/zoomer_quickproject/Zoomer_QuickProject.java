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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private String path = "C:\\Users\\Wei Wang\\Desktop\\Zoomer\\outPut";

    public static void main(String[] args) throws SQLException, IOException {
        
        ZOOMER_TEST[] test = {ZOOMER_TEST.CORN_ZOOMER , ZOOMER_TEST.DAIRY_ZOOMER ,ZOOMER_TEST.EGG_ZOOMER ,ZOOMER_TEST.LECTIN_ZOOMER ,ZOOMER_TEST.PEANUT_ZOOMER};
        String[] table = {"corn_run_23","dairy_run_23","egg_run_23","lectin_run_23","peanut_run_23"};
        
        
        for(int i = 0 ; i < test.length ; i++){
            run(table[i],test[i] );
        }
        
        
        
        
        
//        run("corn_run_23",ZOOMER_TEST.CORN_ZOOMER );
////        Zoomer_QuickProject test = new Zoomer_QuickProject(new DairyZoomer(), "dairy_run_23");
////        Zoomer_QuickProject test = new Zoomer_QuickProject(new EggZoomer(), "egg_run_23");
////        Zoomer_QuickProject test = new Zoomer_QuickProject(new LectinZoomer(), "lectin_run_23");
//        Zoomer_QuickProject test = new Zoomer_QuickProject(new PeanutZoomer(), "peanut_run_23");
//        test.init();
//        test.getData();
//        test.exportExcel();
    }

    private static enum ZOOMER_TEST {
        CORN_ZOOMER,
        DAIRY_ZOOMER,
        LECTIN_ZOOMER,
        PEANUT_ZOOMER,
        EGG_ZOOMER
    }

    private Map<String, Map<String, Float>> map_unit;
    private Map<String, Map<String, List<Float>>> map_raw;
    private Map<String, String[]> loc_sample_map; // test_name , pillarId ,julien Barcode
    private String[] test_code;
    private String table_name, test_name;
    private Condition[] conditions;
    private Map<String, List<Float>> negative_map;  // location  , raw data
    
    private Set<String> exclude_set ;
            
    private Zoomer_QuickProject(Zoomer test, String table_name) {
        this.test_name = test.getTestName();
        this.test_code = test.getTestCode();
        this.conditions = test.getCondition();
        this.table_name = table_name;

        this.map_unit = new LinkedHashMap();
        this.map_raw = new HashMap();
        this.loc_sample_map = new HashMap();
        this.negative_map = new HashMap();
        this.exclude_set = new HashSet();
    }

    private static void run(String table_name, ZOOMER_TEST test) {
        try {
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
            if(zoomer_ctroller == null){
                System.out.println("testZoomer type input is wrong!");
                return;
            }
            if(!precheck){
                System.out.println(" table_name input format is wrong! or is not match the test you select !");
                return;
            
            }
            

            zoomer_ctroller.init();
            zoomer_ctroller.getData();
            zoomer_ctroller.exportExcel();
        } catch (SQLException ex) {
            Logger.getLogger(Zoomer_QuickProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Zoomer_QuickProject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void exportExcel() throws IOException {
        Workbook wb = ExcelOperation.getWriteConnection(ExcelOperation.ExcelType.XLSX);
        Sheet sheet = wb.createSheet(test_name);

        HashMap<String, int[]> align_map = new HashMap();
        for (String location : loc_sample_map.keySet()) {
            String pillarId = loc_sample_map.get(location)[0];
            if (!align_map.containsKey(pillarId)) {
                align_map.put(pillarId, new int[]{(test_code.length + 15) * align_map.size(), 3});
            }
        }

        for (String pillarId : align_map.keySet()) {
            int row = align_map.get(pillarId)[0];
            int col = align_map.get(pillarId)[1];
            sheet.createRow(row++).createCell(col - 1).setCellValue(pillarId);
            sheet.createRow(row++).createCell(col - 1).setCellValue("julienBarcode");
            for (String test : map_unit.keySet()) {
                sheet.createRow(row++).createCell(col - 1).setCellValue(test);
            }
        }

        for (String location : loc_sample_map.keySet()) {
            String pillarId = loc_sample_map.get(location)[0];
            String sample = loc_sample_map.get(location)[1];

            int row_index = 0, col_index = 0;
            if (align_map.containsKey(pillarId)) {
                row_index = align_map.get(pillarId)[0];
                col_index = align_map.get(pillarId)[1];
                align_map.get(pillarId)[1]++;
            } else {
                row_index = (test_code.length + 15) * align_map.size();
                col_index = 3;
                align_map.put(pillarId, new int[]{row_index, col_index + 1});
            }

            sheet.getRow(row_index++).createCell(col_index).setCellValue(location);
            sheet.getRow(row_index++).createCell(col_index).setCellValue(sample);
            for (String test : map_unit.keySet()) {
                float unit = map_unit.get(test).get(location);
                sheet.getRow(row_index++).createCell(col_index).setCellValue(unit);
            }

        }
        ExcelOperation.writeExcel(path + "\\" + table_name + "_" + test_name + ".xlsx", wb);

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
                    
                    if(exclude_set.contains(location)){
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
                        if(exclude_set.contains(location)){
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
            if(sample.matches(".*[a-z].*")){
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

}
