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
public class LectinZoomer extends Zoomer {
    private static float qcArr[] = new float[]{2.1f, 3.9f, 1.05f};
    private static int testCodeCt = 46;
    public static int getTestCodeCount(){
        return testCodeCt;
    }
    public static float[] getQcArr(){
        return qcArr;
    }
    public LectinZoomer() {
        super();
        test_name = "Lectin";
        testcode = new String[]{"BARLEY_LECTIN_IGG",
            "BELL_PEPPER_LECTIN_IGG",
            "CHICKPEA_LECTIN_IGG",
            "CORN_LECTIN_IGG",
            "CUCUMBER_LECTIN_IGG",
            "LENTIL_LECTIN_IGG",
            "LIMA_BEAN_LECTIN_IGG",
            "MUNG_LECTIN_IGG",
            "PEA_LECTIN_IGG",
            "PEANUT_LECTIN_IGG",
            "POTATO_LECTIN_IGG",
            "RICE_LECTIN_IGG",
            "RYE_LECTIN_IGG",
            "SOYBEAN_LECTIN_IGG",
            "TOMATO_LECTIN_IGG",
            "KIDNEY_BEAN_LECTIN_IGG",
            "CORN_AQUAPORIN_IGG",
            "SOYBEAN_AQUAPORIN_IGG",
            "SPINACH_AQUAPORIN_IGG",
            "TOBACCO_AQUAPORIN_IGG",
            "TOMATO_AQUAPORIN_IGG",
            "POTATO_AQUAPORIN_IGG",
            "BELL_PEPPER_AQUAPORIN_IGG",
            "BARLEY_LECTIN_IGA",
            "BELL_PEPPER_LECTIN_IGA",
            "CHICKPEA_LECTIN_IGA",
            "CORN_LECTIN_IGA",
            "CUCUMBER_LECTIN_IGA",
            "LENTIL_LECTIN_IGA",
            "LIMA_BEAN_LECTIN_IGA",
            "MUNG_LECTIN_IGA",
            "PEA_LECTIN_IGA",
            "PEANUT_LECTIN_IGA",
            "POTATO_LECTIN_IGA",
            "RICE_LECTIN_IGA",
            "RYE_LECTIN_IGA",
            "SOYBEAN_LECTIN_IGA",
            "TOMATO_LECTIN_IGA",
            "KIDNEY_BEAN_LECTIN_IGA",
            "CORN_AQUAPORIN_IGA",
            "SOYBEAN_AQUAPORIN_IGA",
            "SPINACH_AQUAPORIN_IGA",
            "TOBACCO_AQUAPORIN_IGA",
            "TOMATO_AQUAPORIN_IGA",
            "POTATO_AQUAPORIN_IGA",
            "BELL_PEPPER_AQUAPORIN_IGA"
        };

        // class , protein , info_id ,squences
        conditions = new Condition[testcode.length / 2];
        conditions[0] = new Condition(".*barley.*lectin.*", "", "", "");
        conditions[1] = new Condition("", ".*jacalin-related lectin.*", "", "");
        conditions[2] = new Condition(".*chickpea.*lectin.*", "", "", "");
        conditions[3] = new Condition(".*corn.*lectin.*", "", "", "");
        conditions[4] = new Condition(".*cucumber.*lectin.*", "", "", "");
        conditions[5] = new Condition(".*lentil.*lectin.*", "", "", "");
        conditions[6] = new Condition(".*lima bean.*lectin.*", "", "", "");
        conditions[7] = new Condition(".*mung.*lectin.*", "", "", "");
        conditions[8] = new Condition("pea lectin.*", "", "", "");
        conditions[9] = new Condition(".*peanut.*lectin.*", "", "", "");
        conditions[10] = new Condition(".*potato.*lectin.*", "", "(?!.*,).*", "");
        conditions[11] = new Condition(".*rice.*lectin.*", "", "", "");
        conditions[12] = new Condition(".*rye.*lectin.*", "", "", "");
        conditions[13] = new Condition(".*soybean.*lectin.*", "", "", "");
        conditions[14] = new Condition(".*tomato.*lectin.*", "", "", "");
        conditions[15] = new Condition(".*Bean phytohemagglutinin.*", "", "", "");
        conditions[16] = new Condition(".*aqp4.*corn.*", "", "", "");
        conditions[17] = new Condition(".*aqp4.*soybean.*", "", "", "");
        conditions[18] = new Condition(".*aqp4.*spinach.*", "", "", "");
        conditions[19] = new Condition(".*aqp4.*tobacco.*", "", "", "");
        conditions[20] = new Condition("", ".*tomato.*aqp4.*", "", "");
        conditions[21] = new Condition(".*potato.*lectin.*", "", ".*,.*", "");
        conditions[22] = new Condition(".*aqp4.*bell pepper.*", "(?!.*jacalin-related lectin).*", "", "");

        double[][] equation_parameter = new double[][]{{0.00347296876148109, -8.93618797600571},
                                            {0.00431799715161495, -11.4951336284665},
                                            {0.00511221904100172, -13.2539188616619},
                                            {0.0050418855830194, -13.2738521835039},
                                            {0.00498220053964774, -13.0080656747247},
                                            {0.00509543287394056, -13.2521973771441},
                                            {0.00468464497180006, -12.0984649963257},
                                            {0.00502613910378926, -13.1857211653327},
                                            {0.00486340936879972, -12.7384849291594},
                                            {0.00371106015790591, -9.40625695950858},
                                            {0.00380911045822212, -10.2101842084556},
                                            {0.00462262346744704, -12.2985083698709},
                                            {0.00484686090750682, -12.5235829827209},
                                            {0.00501559405358085, -13.269800012922},
                                            {0.00274029225839764, -7.11504956475975},
                                            {0.00507719604944719, -13.2011100174995},
                                            {0.00429949816334044, -11.237757230786},
                                            {0.00378561013667757, -9.16744107499454},
                                            {0.00437148473625977, -11.1669942602784},
                                            {0.00326131946361922, -8.00774678883423},
                                            {0.00259400548510251, -4.15212053274583},
                                            {0.00198198908692506, -4.85820693834753},
                                            {0.00476992697619852, -12.6081784916383},
                                            {0.00366736513023147, -9.6354166378524},
                                            {0.003302771062345, -9.0157007234},
                                            {0.0030126964169254, -7.9655735743885},
                                            {0.00543188611226814, -15.0161267995875},
                                            {0.00326654572999725, -8.83387414483201},
                                            {0.0029153624975206, -7.69482286849591},
                                            {0.00343541900764633, -9.26817389792797},
                                            {0.00383023271984661, -10.4050347133584},
                                            {0.0030279693108987, -8.08691956718254},
                                            {0.00228104232511199, -5.71684799803828},
                                            {0.00334490065485901, -8.9535763144184},
                                            {0.00453854097033823, -12.4984342384722},
                                            {0.00461934391362945, -12.4643599460622},
                                            {0.00317464814109007, -8.45390589990151},
                                            {0.00294240101965159, -7.82790091363888},
                                            {0.00322728335427823, -8.61729422596199},
                                            {0.00487564644332141, -13.5782932699711},
                                            {0.0040434505000155, -10.8774349820548},
                                            {0.00288931961818897, -7.72820800556971},
                                            {0.00330198326960127, -8.85380935380774},
                                            {0.00176600073856328, -2.61370729356786},
                                            {0.00175579817508805, -4.01592822926875},
                                            {0.00511874789300701, -13.9519885274349}
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
"        join `vibrant_america_test_result`.`result_lectin_aquaporin_panel1` rwp1 on rwp1.sample_id = sd.sample_id\n" +
"        join `vibrant_america_test_result`.`result_lectin_aquaporin_panel2` rwp2 on rwp2.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.order_lectin_aquaporin_panel1 != 0 \n" +
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
    "`vibrant_america_test_result`.result_lectin_aquaporin_panel1 as a on sd.sample_id = a.sample_id join\n" +
    "`vibrant_america_test_result`.result_lectin_aquaporin_panel2 as b on sd.sample_id = b.sample_id\n" +
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
