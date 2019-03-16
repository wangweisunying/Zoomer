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
public class PeanutZoomer extends Zoomer {
    private static float qcArr[] = new float[]{1.9f, 4.5f, 0.9f};
    private static int testCodeCt = 32;
    public static int getTestCodeCount(){
        return testCodeCt;
    }
    public static float[] getQcArr(){
        return qcArr;
    }
    public PeanutZoomer() {
        super();
        test_name = "Peanut";
        testcode = new String[]{"ARA_H_1__CONARACHIN__IGG",
                                "ARA_H_3_IGG",
                                "ARACHIN_IGG",
                                "GLYCININ_IGG",
                                "ARA_H_2__CONGLUTIN_7__IGG",
                                "ARA_H_6__CONGLUTIN_8__IGG",
                                "ARA_H_7_IGG",
                                "ARA_H_9_IGG",
                                "ARA_H_5_IGG",
                                "ARA_H_8__ARA_H_8_ISOFORM_IGG",
                                "ARA_H_10__OLEOSIN_1__IGG",
                                "ARA_H_11__OLEOSIN_2__IGG",
                                "OLEOSIN_VARIANT_A_IGG",
                                "OLEOSIN_VARIANT_B_IGG",
                                "ARA_H_12__DEFENSIN_1__IGG",
                                "ARA_13__DEFENSIN_2___DEFENSIN_3__IGG",
                                "ARA_H_1__CONARACHIN__IGA",
                                "ARA_H_3_IGA",
                                "ARACHIN_IGA",
                                "GLYCININ_IGA",
                                "ARA_H_2__CONGLUTIN_7__IGA",
                                "ARA_H_6__CONGLUTIN_8__IGA",
                                "ARA_H_7_IGA",
                                "ARA_H_9_IGA",
                                "ARA_H_5_IGA",
                                "ARA_H_8__ARA_H_8_ISOFORM_IGA",
                                "ARA_H_10__OLEOSIN_1__IGA",
                                "ARA_H_11__OLEOSIN_2__IGA",
                                "OLEOSIN_VARIANT_A_IGA",
                                "OLEOSIN_VARIANT_B_IGA",
                                "ARA_H_12__DEFENSIN_1__IGA",
                                "ARA_13__DEFENSIN_2___DEFENSIN_3__IGA"
                                };
        
        // class , protein , info_id ,squences
        conditions = new Condition[testcode.length / 2];
        conditions[0] = new Condition("" , ".*ara.*h 1.*" , "", "");
        conditions[1] = new Condition("" , ".*ara.*h 3.*" , "", "");
        conditions[2] = new Condition("" , ".*arachin.*" , "", "");
        conditions[3] = new Condition("" , ".*glycinin.*" , "", "");
        conditions[4] = new Condition("" , ".*conglutin-7.*" , "", "");
        conditions[5] = new Condition("" , ".*ara.*h 6.*" , "", "");
        conditions[6] = new Condition("" , ".*ara.*h 7.*" , "", "");
        conditions[7] = new Condition("" , ".*ara.*h9.*" , "", "");
        conditions[8] = new Condition("" , ".*ara.*h5.*" , "", "");
        conditions[9] = new Condition("" , ".*ara.*h8.*" , "", "");
        conditions[10] = new Condition("" , ".*ara.*h10.*" , "", "");
        conditions[11] = new Condition("" , ".*ara.*h11.*" , "", "");
        conditions[12] = new Condition("" , ".*oleosin variant A.*" , "", "");
        conditions[13] = new Condition("" , ".*oleosin variant B.*" , "", "");
        conditions[14] = new Condition("" , ".*ara.*h12.*" , "", "");
        conditions[15] = new Condition("" , ".*ara.*h13.*" , "", "");
        
        double [][] equation_parameter = new double[][]{{0.00760829302585525,-17.0916713445414},
                                                        {0.0063185559846399,-14.2717449477209},
                                                        {0.00785645482961662,-17.7243722722575},
                                                        {0.00788756099183625,-18.0275739873114},
                                                        {0.0054352926705358,-11.5731590072318},
                                                        {0.00623321922711856,-13.8032170600559},
                                                        {0.00739521540831386,-16.9438027892239},
                                                        {0.00723532852153219,-18.8597628404743},
                                                        {0.00414922368954388,-9.10314924101245},
                                                        {0.00823681447433278,-19.4623704410571},
                                                        {0.00491185604521062,-12.0508956489882},
                                                        {0.00370299747040296,-8.86055161834029},
                                                        {0.00708064449914522,-15.5501307367428},
                                                        {0.0065523801300486,-14.4461166164391},
                                                        {0.00760198129066903,-16.2910644686412},
                                                        {0.00567187195251312,-12.2053826257656},
                                                        {0.00886921001822099,-22.1237970541205},
                                                        {0.0084031865611097,-20.8001375870541},
                                                        {0.00883446146588965,-21.9784689970906},
                                                        {0.00910112818438505,-22.9222120975621},
                                                        {0.00988442106996127,-24.8765723585905},
                                                        {0.00973610769837371,-24.1882242981108},
                                                        {0.00772270349853061,-19.47413016923},
                                                        {0.00801832145160187,-21.3550359386343},
                                                        {0.00961240797739413,-25.0266934863835},
                                                        {0.00898202834255616,-22.6980199410886},
                                                        {0.00444858082724306,-10.543934443017},
                                                        {0.00525333687514256,-13.2871116033333},
                                                        {0.00876677539287814,-22.3157122663085},
                                                        {0.00633921025036004,-15.5397857810421},
                                                        {0.00668814175603376,-15.4621696407153},
                                                        {0.00756194864036901,-18.5478729497231}
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
"        join `vibrant_america_test_result`.`result_peanut_zoomer_panel1` rwp1 on rwp1.sample_id = sd.sample_id\n" +
"        join `vibrant_america_test_result`.`result_peanut_zoomer_panel2` rwp2 on rwp2.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.order_peanut_zoomer_panel1 != 0 \n" +
"   group by PD.PATIENT_ID having count(*)>=2 and julien REGEXP '"+ sqlJu.replaceAll(",", "|") +"'   order by substring(group_concat(sd.julien_barcode order by sd.julien_barcode desc),1,10) desc;\n" +
"";
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
    "`vibrant_america_test_result`.result_peanut_zoomer_panel1 as a on sd.sample_id = a.sample_id join\n" +
    "`vibrant_america_test_result`.result_peanut_zoomer_panel2 as b on sd.sample_id = b.sample_id\n" +
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


