/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomer_quickproject;

/**
 *
 * @author Wei Wang
 */
public class CornZoomer extends Zoomer {

    public CornZoomer() {
        
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
        conditions[0] = new Condition(".*albumin.*" , "" , "" , "");
        conditions[1] = new Condition(".*globulin.*" , "" , "", "");
        conditions[2] = new Condition(".*glutenin.*" , "" , "", "");
        conditions[3] = new Condition("" , ".*expansin.*" , "", "");
        conditions[4] = new Condition("" , ".*endochitinase.*" ,"" ,"");
        conditions[5] = new Condition("" , ".*profilin.*" , "", "");
        conditions[6] = new Condition("" , ".*lipid-transfer.*" , "", "");
        conditions[7] = new Condition("" , ".*thioredoxin.*" , "", "");
        conditions[8] = new Condition("" , ".*exopolygalacturonase.*" , "", "");
        conditions[9] = new Condition("" , ".*pollen.*" , "", "");
        conditions[10] = new Condition("" , ".*cry1a.*%.*cry1ab.*%.*cry2ab.*%.*cry3b.*%.*cry9c.*" , "", "");
        conditions[11] = new Condition(".*wheat.*%.*corn epitope.*" , "" , "", "");
        conditions[12] = new Condition(".*zein.*" , "" , "", "");
    }
}
