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
public class DairyZoomer extends Zoomer {

    public DairyZoomer() {
        
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
        
    }
}
