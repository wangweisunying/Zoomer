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
public class NeuralCondition extends Condition {
    private String gene;
    public NeuralCondition(String class_name, String protein_name, String info_id, String seq , String gene) {
        super(class_name, protein_name, info_id, seq);
        this.gene = gene;
    }
    @Override
    public String getGene(){
        return this.gene;
    }
    
}
