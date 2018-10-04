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
public class PeanutZoomer extends Zoomer {

    public PeanutZoomer() {
        
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
        
    }
}

