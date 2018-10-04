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
public class EggZoomer extends Zoomer {

    public EggZoomer() {
        
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
        conditions[0] = new Condition(".*ovomucoid.*" , "" , "", "");
        conditions[1] = new Condition(".*ovalbumin.*" , "" , "", "");
        conditions[2] = new Condition(".*ovomucin.*" , "" , "", "");
        conditions[3] = new Condition(".*ovotransferrin.*" , "" , "", "");
        conditions[4] = new Condition(".*lysozyme.*" , "" , "", "");
        conditions[5] = new Condition(".*avidin.*" , "" , "", "");
        conditions[6] = new Condition(".*lipovitellin.*" , "" , "", "");
        conditions[7] = new Condition("" , ".*ygp42.*" , "", "");
        conditions[8] = new Condition(".*vitellogenin.*" , "" , "", "");
        conditions[9] = new Condition(".*alpha.*livetin.*" , "" , "", "");
        conditions[10] = new Condition(".*apovitellenin.*" , "" , "", "");
        
    }
}