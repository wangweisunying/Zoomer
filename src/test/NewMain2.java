/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import model.Math_Tool;


/**
 *
 * @author Wei Wang
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList(Arrays.asList("1","1","1"));
        
        Set<String> set = new HashSet(list);
       
        System.out.println(set);
    }
    

}



