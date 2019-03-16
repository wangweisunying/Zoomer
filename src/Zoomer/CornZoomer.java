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
public class CornZoomer extends Zoomer {
    
    private static float qcArr[] = new float[]{2.0f, 4.5f, 1.0f};
    private static int testCodeCt = 26;
    public static int getTestCodeCount(){
        return testCodeCt;
    }
    public static float[] getQcArr(){
        return qcArr;
    }
    public CornZoomer() {
        super();
        test_name = "Corn";
        testcode = new String[]{"CORN_ALBUMIN_IGG",
            "CORN_GLOBULIN_IGG",
            "CORN_GLUTELIN_IGG",
            "CORN_EXPANSIN_IGG",
            "CORN_ENDOCHITINASE_IGG",
            "CORN_PROFILIN_IGG",
            "CORN_LIPID_TRANSFER_PROTEIN_IGG",
            "CORN_THIOREDOXIN_IGG",
            "CORN_EXOPOLYGALACTURONASE_IGG",
            "CORN_POLLEN_ALLERGEN_IGG",
            "CORN_CRY_PROTEIN_IGG",
            "CORN_WHEAT_OVERLAP_EPITOPE_IGG",
            "CORN_ZEIN_IGG",
            "CORN_ALBUMIN_IGA",
            "CORN_GLOBULIN_IGA",
            "CORN_GLUTELIN_IGA",
            "CORN_EXPANSIN_IGA",
            "CORN_ENDOCHITINASE_IGA",
            "CORN_PROFILIN_IGA",
            "CORN_LIPID_TRANSFER_PROTEIN_IGA",
            "CORN_THIOREDOXIN_IGA",
            "CORN_EXOPOLYGALACTURONASE_IGA",
            "CORN_POLLEN_ALLERGEN_IGA",
            "CORN_CRY_PROTEIN_IGA",
            "CORN_WHEAT_OVERLAP_EPITOPE_IGA",
            "CORN_ZEIN_IGA"
        };

        // class , protein , info_id
        conditions = new Condition[testcode.length / 2];
        conditions[0] = new Condition(".*albumin.*", "", "", "");
        conditions[1] = new Condition(".*globulin.*", "", "", "");
        conditions[2] = new Condition(".*glutenin.*", "", "", "");
        conditions[3] = new Condition("", ".*expansin.*", "", "");
        conditions[4] = new Condition("", ".*endochitinase.*", "", "");
        conditions[5] = new Condition("", ".*profilin.*", "", "");
        conditions[6] = new Condition("", ".*lipid-transfer.*", "", "");
        conditions[7] = new Condition("", ".*thioredoxin.*", "", "");
        conditions[8] = new Condition("", ".*exopolygalacturonase.*", "", "");
        conditions[9] = new Condition("", ".*pollen.*", "", "");
        conditions[10] = new Condition("", ".*cry1a.*%.*cry1ab.*%.*cry2ab.*%.*cry3b.*%.*cry9c.*", "", "");
        conditions[11] = new Condition(".*wheat.*%.*corn epitope.*", "", "", "");
        conditions[12] = new Condition(".*zein.*", "", "", "");

        double[][] equation_parameter = new double[][]{{0.00381674575239461, -9.45478121587462},
        {0.00346207686909395, -7.95723902323773},
        {0.00447231486020168, -10.642995502192},
        {0.00260598160146982, -6.24691242540092},
        {0.00304129513171131, -7.22904684148294},
        {0.00365597220078411, -8.32906566943735},
        {0.00365044044891549, -8.32588886790015},
        {0.00375589942451192, -7.77766531377987},
        {0.00326811577499867, -7.30976711740536},
        {0.0035568493224024, -8.45017118150469},
        {0.00405470664615142, -8.94939642563032},
        {0.00360603831312374, -6.31956206011886},
        {0.00188626514122333, -3.33850530145147},
        {0.00270496096815348, -6.72047501381165},
        {0.00302825852271621, -7.40525446625957},
        {0.00249975083178324, -6.29672081277415},
        {0.00219168381292357, -5.51353809663797},
        {0.00242560112962084, -6.12786737675095},
        {0.00261278726413818, -6.40203352043353},
        {0.00277040555266618, -6.79068982089953},
        {0.00390376873749499, -8.83267502199267},
        {0.00278101538951741, -6.62738368480475},
        {0.00282986465012294, -7.01871800362339},
        {0.00319154062778115, -7.57401923923269},
        {0.00372533444550496, -8.05795038216196},
        {0.00204150380112912, -5.54203950380902}};
        for (int i = 0; i < testcode.length; i++) {
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
"        join `vibrant_america_test_result`.`result_corn_zoomer_panel1` rwp on rwp.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.order_corn_zoomer_panel1 != 0 \n" +
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
    "`vibrant_america_test_result`.result_corn_zoomer_panel1 as a on sd.sample_id = a.sample_id\n" +
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
