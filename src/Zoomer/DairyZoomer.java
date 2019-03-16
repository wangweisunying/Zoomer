/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoomer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DataBaseCon;
import model.LXDataBaseCon;
import model.StringOperation;

/**
 *
 * @author Wei Wang
 */
public class DairyZoomer extends Zoomer {
    private static float qcArr[] = new float[]{1.9f, 4.5f, 0.9f};
    private static int testCodeCt = 22;
    public static int getTestCodeCount(){
        return testCodeCt;
    }
    public static float[] getQcArr(){
        return qcArr;
    }
    
    public DairyZoomer() {
        super();
        test_name = "Dairy";
        testcode = new String[]{"AS1_CASEIN_AND_AS2_CASEIN_IGG",
                                "AS2_CASEIN_AND_RETINAL_S_ANTIGEN_OVERLAP_IGG",
                                "KAPPA_CASEIN_IGG",
                                "A1_B_CASEIN_AND_ISLET_CELL_OVERLAP_IGG",
                                "B_CASEIN_IGG",
                                "BETA_CASOMORPHINS__BCM__IGG",
                                "A_LACTALBUMIN_IGG",
                                "B__LACTOGLOBULIN_IGG",
                                "SERUM_ALBUMIN_IGG",
                                "LACTOFERRIN_IGG",
                                "BUTYROPHILIN_IGG",
                                "AS1_CASEIN_AND_AS2_CASEIN_IGA",
                                "AS2_CASEIN_AND_RETINAL_S_ANTIGEN_OVERLAP_IGA",
                                "KAPPA_CASEIN_IGA",
                                "A1_B_CASEIN_AND_ISLET_CELL_OVERLAP_IGA",
                                "B_CASEIN_IGA",
                                "BETA_CASOMORPHINS__BCM__IGA",
                                "A_LACTALBUMIN_IGA",
                                "B__LACTOGLOBULIN_IGA",
                                "SERUM_ALBUMIN_IGA",
                                "LACTOFERRIN_IGA",
                                "BUTYROPHILIN_IGA",
                                };
        
        // class , protein , info_id ,squences
        conditions = new Condition[testcode.length / 2];
        conditions[0] = new Condition("" , ".*Alpha-S1-casein.*%.*Alpha-S2-casein.*" , "", "");
        conditions[1] = new Condition("" , ".*retinal.*antigen.*" , "", "");
        conditions[2] = new Condition("" , ".*kappa-casein.*" , "", "");
        conditions[3] = new Condition("" , ".*Milk-Islet cell mimic.*" , "", "");
        conditions[4] = new Condition("" , ".*beta.*casein.*" , "", "");
        conditions[5] = new Condition("" , "" , "", ".*ypfpgpi.*");
        conditions[6] = new Condition("" , ".*alpha-lactalbumin.*" , "", "");
        conditions[7] = new Condition("" , ".*beta-lactoglobulin.*" , "", "");
        conditions[8] = new Condition("" , ".*serum albumin.*" , "", "");
        conditions[9] = new Condition("" , ".*lactoferrin.*" , "", "");
        conditions[10] = new Condition(".*Milk-MOG Overlap.*" , "" , "", "");
        
        double[][] equation_parameter = new double[][]{{0.00539811112586686,-10.7022665548612},
                                            {0.00564300719022352,-11.8080315721052},
                                            {0.00455072462848364,-9.47416930987544},
                                            {0.00386796179265963,-6.60838562881968},
                                            {0.00363242390962059,-8.03747799559018},
                                            {0.00484468729990247,-11.9963038250159},
                                            {0.00619540007486425,-12.0156000462406},
                                            {0.00560100745429809,-10.7625951638501},
                                            {0.00557126630111688,-10.648269239643},
                                            {0.00491956860734958,-10.1915187924075},
                                            {0.00587508708480234,-11.6375233323056},
                                            {0.00391648911087468,-9.58689428926699},
                                            {0.00336362227775466,-7.79747487692323},
                                            {0.00186062313727825,-4.21291836790039},
                                            {0.00362280072485753,-7.96451374120286},
                                            {0.00385597733349896,-9.89793439626797},
                                            {0.00395527291385359,-10.8532266315647},
                                            {0.00441272397413406,-10.6348825361625},
                                            {0.00413150204824263,-9.65951032160843},
                                            {0.00428044932719926,-10.1384241650279},
                                            {0.00415414812133167,-10.2399512166561},
                                            {0.00437464328653381,-10.6275123374617}
                                            };
       
        for(int i = 0 ; i < testcode.length ; i++){
            equation_parameter_map.put(testcode[i], equation_parameter[i]);
        }
    }
    public static Map<String , DupData> getDupUnitData(Map<String , String[]> loc_sample_map) throws SQLException, Exception{
        Map<String , DupData> mapUnit = new HashMap();
        
        List<Integer> julienList = new ArrayList();
        for(String[] info : loc_sample_map.values()){
            julienList.add(Integer.parseInt(info[1]));
        }
        String sqlJu = StringOperation.getSampleSql(julienList).toString();
        
         Map<String , String> old2NewMap = new HashMap();
        DataBaseCon db = new LXDataBaseCon();
        String sql = "SELECT\n" +
"   group_concat(sd.julien_barcode order by sd.julien_barcode desc) as julien\n" +
"FROM\n" +
"    vibrant_america_information.`patient_details` pd\n" +
"        JOIN\n" +
"    vibrant_america_information.`sample_data` sd ON sd.`patient_id` = pd.`patient_id`\n" +
"        JOIN\n" +
"    vibrant_america_information.`customers_of_patients` cop ON cop.`patient_id` = sd.`patient_id`\n" +
"        AND cop.`customer_id` = sd.`customer_id`\n" +
"        join\n" +
"          vibrant_america_information.`customer_details` cd on  cd.customer_id = sd.customer_id\n" +
"        AND cop.`customer_id` = sd.`customer_id`\n" +
"        join vibrant_america_information.selected_test_list slt on slt.sample_id = sd.sample_id\n" +
"        join `vibrant_america_test_result`.`result_dairy_zoomer_panel1` rwp on rwp.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.order_dairy_zoomer_panel1 != 0 \n" +
"   group by PD.PATIENT_ID having count(*)>=2 and julien REGEXP '"+ sqlJu.replaceAll(",", "|")  +"'   order by substring(group_concat(sd.julien_barcode order by sd.julien_barcode desc),1,10) desc;";
        System.out.println(sql);
        ResultSet rs = db.read(sql);
        while(rs.next()){
            String[] tmp = rs.getString(1).split(",");
            old2NewMap.putIfAbsent(tmp[1], tmp[0]);
        }
        
        List<Integer> newJulienList = new ArrayList();
        for(String tmp : old2NewMap.keySet()) newJulienList.add(Integer.parseInt(tmp));
    
        if(!newJulienList.isEmpty()){
            String sqlData = 
    "select julien_barcode , a.* from vibrant_america_information.sample_data as sd join\n" +
    "`vibrant_america_test_result`.result_dairy_zoomer_panel1 as a on sd.sample_id = a.sample_id\n" +
    " where julien_barcode in ("+ StringOperation.getSampleSql(newJulienList).toString() +");";
            ResultSet rsData = db.read(sqlData);
            
            int col = rsData.getMetaData().getColumnCount();
            while(rsData.next()){
                 Map<String ,Float> curMap = new HashMap();
                 String oldJulien = rsData.getString(1);
                 String newJulien = old2NewMap.get(oldJulien);
                 for(int i = 2 ; i <= col ; i++){
                     String label = rsData.getMetaData().getColumnLabel(i);
                     if(label.equals("sample_id")) continue;
                     curMap.put(label , rsData.getFloat(i));
                 }
                 mapUnit.put(newJulien , new DupData(oldJulien , curMap));
            }
        }
        db.close();
        return mapUnit;
    }
}
