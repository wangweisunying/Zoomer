/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoomer;

import java.util.HashMap;

/**
 *
 * @author Wei Wang
 */
public class CornZoomer extends Zoomer {

    private static float qcArr[] = new float[]{2.0f, 4.5f, 1.0f};
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

}
