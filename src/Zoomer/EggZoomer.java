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
public class EggZoomer extends Zoomer {
    private static float qcArr[] = new float[]{2.0f, 4.5f, 1.0f};
    private static int testCodeCt = 22;
    public static int getTestCodeCount(){
        return testCodeCt;
    }
    public static float[] getQcArr(){
        return qcArr;
    }
    public EggZoomer() {
        super();
        test_name = "Egg";
        testcode = new String[]{"OVOMUCOID_IGG",
            "OVALBUMIN_IGG",
            "OVOMUCIN_IGG",
            "OVOTRANSFERRIN_IGG",
            "LYSOZYME__IGG",
            "AVIDIN_IGG",
            "LIPOVITELLIN_IGG",
            "YGP42_IGG",
            "VITELLOGENIN_1_IGG",
            "ALPHA_LIVETIN_IGG",
            "APOVITELLENIN_IGG",
            "OVOMUCOID_IGA",
            "OVALBUMIN_IGA",
            "OVOMUCIN_IGA",
            "OVOTRANSFERRIN_IGA",
            "LYSOZYME__IGA",
            "AVIDIN_IGA",
            "LIPOVITELLIN_IGA",
            "YGP42_IGA",
            "VITELLOGENIN_1_IGA",
            "ALPHA_LIVETIN_IGA",
            "APOVITELLENIN_IGA"
        };

        // class , protein , info_id ,squences
        conditions = new Condition[testcode.length / 2];
        conditions[0] = new Condition(".*ovomucoid.*", "", "", "");
        conditions[1] = new Condition(".*ovalbumin.*", "", "", "");
        conditions[2] = new Condition(".*ovomucin.*", "", "", "");
        conditions[3] = new Condition(".*ovotransferrin.*", "", "", "");
        conditions[4] = new Condition(".*lysozyme.*", "", "", "");
        conditions[5] = new Condition(".*avidin.*", "", "", "");
        conditions[6] = new Condition(".*lipovitellin.*", "", "", "");
        conditions[7] = new Condition("", ".*ygp42.*", "", "");
        conditions[8] = new Condition(".*vitellogenin.*", "", "", "");
        conditions[9] = new Condition(".*alpha.*livetin.*", "", "", "");
        conditions[10] = new Condition(".*apovitellenin.*", "", "", "");

        double[][] equation_parameter = new double[][]{{0.00661881737845663, -14.9447569741323},
                                            {0.00336733811809464, -7.31381302380916},
                                            {0.00862977496444703, -20.1660661910231},
                                            {0.00452508044553742, -10.4506285665995},
                                            {0.0036874356043223, -8.29563739033806},
                                            {0.00677135676819173, -16.1405692545764},
                                            {0.00458859210461051, -10.8142159921288},
                                            {0.00542756353998968, -13.4004083079428},
                                            {0.00462895115467531, -10.8891897208381},
                                            {0.00391430995554889, -8.80844553609891},
                                            {0.00502808806579965, -11.249584774059},
                                            {0.00260996441814099, -6.095859734132},
                                            {0.00261724013025232, -6.08848273144061},
                                            {0.0026087092639135, -6.15706006395846},
                                            {0.00292238296300653, -6.99853713851132},
                                            {0.00400206700716208, -10.1324878741582},
                                            {0.00342281494959724, -8.55722721128878},
                                            {0.00281424030119387, -6.84180725353914},
                                            {0.00462087203257524, -11.8602999037765},
                                            {0.0025954077345629, -6.24882211831524},
                                            {0.00331648531565094, -8.03155303372759},
                                            {0.00359850969323752, -8.6930968175218}
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
"        join `vibrant_america_test_result`.`result_egg_zoomer_panel1` rwp on rwp.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.order_egg_zoomer_panel1 != 0 \n" +
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
    "`vibrant_america_test_result`.result_egg_zoomer_panel1 as a on sd.sample_id = a.sample_id\n" +
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
