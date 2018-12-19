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
public class NeuralDupData{
    private Map<String , Float> unitMap;
    private String julienBarcode;
    NeuralDupData(String julienBarcode , Map<String , Float> unitMap){
        this.unitMap = unitMap;
        this.julienBarcode = julienBarcode;
    }
    public Map<String , Float> getUnitMap(){
        return this.unitMap;
    }
    public String getJulienBarcode(){
        return this.julienBarcode;
    }
}
