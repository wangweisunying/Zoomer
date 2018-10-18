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
public class Zoomer_Unit {

    //insert into `tsp_test_unit_data`.`zoomers_unit_data` values ('CORN_ALBUMIN_IGG','1809190213','0.964987944825308','TST2847T22847N11','D','1',0,now());
    private String testName ,test_code, julien_barcode , pillarId, row, col;
    private double unit;

    public Zoomer_Unit(String testName ,String test_code, String julien_barcode, double unit, String pillarId, String row, String col) {
        this.testName = testName;
        this.test_code = test_code;
        this.julien_barcode = julien_barcode;
        this.unit = unit;
        this.pillarId = pillarId;
        this.row = row;
        this.col = col;
    }
    public String getTestName() {
        return this.testName;
    }
    public String getTestCode() {
        return this.test_code;
    }

    public String getJulienBarcode() {
        return this.julien_barcode;
    }

    public double getUnit() {
        return this.unit;
    }

    public String getPillarId() {
        return this.pillarId;
    }

    public String getRow() {
        return this.row;
    }

    public String getCol() {
        return this.col;
    }
}
