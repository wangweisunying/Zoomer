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
public class Condition {
    protected String class_name , protein_name ,info_id ,seq;
    protected Condition(String class_name , String protein_name , String info_id ,String seq){
        this.class_name = class_name;
        this.protein_name = protein_name;
        this.info_id = info_id;
        this.seq = seq;
    }
    
    public String getClassName(){
        return class_name;
    }
    public String getProteinName(){
        return protein_name;
    }
    public String getInfoId(){
        return info_id;
    }
    public String getSeq(){
        return seq;
    }
    public String getGene(){
        return "";
    }
}
