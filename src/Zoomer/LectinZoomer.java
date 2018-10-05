/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoomer;

/**
 *
 * @author Wei Wang
 */
public class LectinZoomer extends Zoomer {

    public LectinZoomer() {
        
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
        conditions[0] = new Condition(".*barley.*lectin.*" , "" , "", "");
        conditions[1] = new Condition("" , ".*jacalin-related lectin.*" , "", "");
        conditions[2] = new Condition(".*chickpea.*lectin.*" , "" , "", "");
        conditions[3] = new Condition(".*corn.*lectin.*" , "" , "", "");
        conditions[4] = new Condition(".*cucumber.*lectin.*" , "" , "", "");
        conditions[5] = new Condition(".*lentil.*lectin.*" , "" , "", "");
        conditions[6] = new Condition(".*lima bean.*lectin.*" , "" , "", "");
        conditions[7] = new Condition(".*mung.*lectin.*" , "" , "", "");
        conditions[8] = new Condition("pea lectin.*" , "" , "", "");
        conditions[9] = new Condition(".*peanut.*lectin.*" , "" , "", "");
        conditions[10] = new Condition(".*potato.*lectin.*" , "" , "(?!.*,).*", "");
        conditions[11] = new Condition(".*rice.*lectin.*" , "" , "", "");
        conditions[12] = new Condition(".*rye.*lectin.*" , "" , "", "");
        conditions[13] = new Condition(".*soybean.*lectin.*" , "" , "", "");
        conditions[14] = new Condition(".*tomato.*lectin.*" , "" , "", "");
        conditions[15] = new Condition(".*Bean phytohemagglutinin.*" , "" , "", "");
        conditions[16] = new Condition(".*aqp4.*corn.*" , "" , "", "");
        conditions[17] = new Condition(".*aqp4.*soybean.*" , "" , "", "");
        conditions[18] = new Condition(".*aqp4.*spinach.*" , "" , "", "");
        conditions[19] = new Condition(".*aqp4.*tobacco.*" , "" , "", "");
        conditions[20] = new Condition("" , ".*tomato.*aqp4.*" , "", "");
        conditions[21] = new Condition(".*potato.*lectin.*" , "" , ".*,.*", "");
        conditions[22] = new Condition(".*aqp4.*bell pepper.*" , "(?!.*jacalin-related lectin).*" , "", "");
        
    }
}
