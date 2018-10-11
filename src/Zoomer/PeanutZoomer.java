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
public class PeanutZoomer extends Zoomer {

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
}

