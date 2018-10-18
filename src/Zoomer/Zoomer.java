/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoomer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wei Wang
 */
public class Zoomer {
    
    protected Map< String , double[]> equation_parameter_map;
    protected String test_name;
    protected String[] testcode;
    protected Condition[] conditions;
    public Zoomer(){
        equation_parameter_map = new HashMap();
    }

    public String getTestName() {
        return this.test_name;
    }

    public String[] getTestCode() {
        return this.testcode;
    }

    public Condition[] getCondition() {
        return this.conditions;
    }
 
    public Map< String , double[]> getEquationParameterMap(){
        return this.equation_parameter_map;
    }

}
