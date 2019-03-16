/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoomer;

import java.util.Map;

/**
 *
 * @author Wei Wang
 */
public class NeuralDupData extends DupData{
    NeuralDupData(String julienBarcode , Map<String , Float> unitMap){
        super(julienBarcode , unitMap);
    }
}
