/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoomer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.DataBaseCon;
import model.LXDataBaseCon;
import model.Math_Tool;
import model.StringOperation;

/**
 *
 * @author Wei Wang
 */
public class NeuralZoomer extends Zoomer {
    
    
    private static double percentileDis = 500;
    private static double percentileOffset = 2000;        
            
    private static float qcArr[] = new float[]{9.8f, 24.5f, 1.05f};
    private static int testCodeCt = 110;
    private static int[][] testAgeRange = new int[][]{{0,18},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {0,18},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {0,18},
                                                        {0,18},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,18},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {0,18},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {18,40},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {0,18},
                                                        {0,18},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {40,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100},
                                                        {0,100}
                                                        };
    private static double[][] testPercentile = new double[][]{{0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.6,0.8},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.85,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95},
                                                    {0.9,0.95}};
    
   

    public static int[][] getTestAgeRange() {
        return testAgeRange;
    }

    public static double[][] getTestPercentile() {
        return testPercentile;
    }

    public static int getTestCodeCount() {
        return testCodeCt;
    }

    public static float[] getQcArr() {
        return qcArr;
    }

    public NeuralZoomer() {
        super();
        test_name = "Neural";
        testcode = new String[]{"TUBULIN_IGG_IGA_V3",
            "MYELIN_BASIC_IGG_IGA_V3",
            "MYELIN_OLIGODENDROCYTE_GLYCOIGG_IGA_V3",
            "MYELIN_PROTEOLIPID_IGG_IGA_V3",
            "NEUROFASCIN_IGG_IGA_V3",
            "MAG_IGG_IGA_V3",
            "S100B_IGG_IGA_V3",
            "GLIAL_FIBRILLARY_ACIDIC_IGG_IGA_V3",
            "MICROGLIA_IGG_IGA_V3",
            "GLUCOSE_REGULATED_78_IGG_IGA_V3",
            "NEURON_SPECIFIC_ENOLASE_IGG_IGA_V3",
            "AQUAPORIN4_IGG_IGA_V3",
            "RECOVERIN_IGG_IGA_V3",
            "CV2_IGG_IGA_V3",
            "GM1_IGG_IGA_V3",
            "GM2_IGG_IGA_V3",
            "HU_IGG_IGA_V3",
            "RI_IGG_IGA_V3",
            "AMPHIPHYSIN_IGG_IGA_V3",
            "ACETYLCHOLINE_R_IGG_IGA_V3",
            "MUSCLE_SPECIFIC_KINASE_IGG_IGA_V3",
            "VOLTAGE_GATED_CALCIUM_IGG_IGA_V3",
            "VOLTAGE_GATED_POTASSIUM_IGG_IGA_V3",
            "TITIN_IGG_IGA_V3",
            "HSV1_IGG_IGA_V3",
            "CEREBELLUM_IGG_IGA_V3",
            "PURKINJE_CELL_IGG_IGA_V3",
            "YO_IGG_IGA_V3",
            "AMYLOID_BETA__25_35__IGG_IGA_V3",
            "AMYLOID_BETA__1_42__IGG_IGA_V3",
            "RAGE_PEPTIDE_IGG_IGA_V3",
            "TAU_IGG_IGA_V3",
            "GLUTAMATE_IGG_IGA_V3",
            "DOPAMINE_IGG_IGA_V3",
            "HYDROXYTRYPTAMINE_IGG_IGA_V3",
            "ALPHA_SYNUCLEIN_IGG_IGA_V3",
            "A1_AND_B2_ADRENERGIC_R_IGG_IGA_V3",
            "ENDOTHELIN_A_RECEPTOR_IGG_IGA_V3",
            "NMDA_RECEPTOR_IGG_IGA_V3",
            "AMPA_RECEPTOR_IGG_IGA_V3",
            "DOPAMINE_RECEPTOR_1_IGG_IGA_V3",
            "DOPAMINE_RECEPTOR_2_IGG_IGA_V3",
            "GABA_R_IGG_IGA_V3",
            "DIPEPTIDYL_AMINOPEPTIDASE_6_IGG_IGA_V3",
            "GLYCINE_RECEPTOR_IGG_IGA_V3",
            "NEUREXIN_3_IGG_IGA_V3",
            "CONTACTIN_ASSOCIATED_2_IGG_IGA_V3",
            "LEUCINE_RICH_GLIOMA_1__LGI1__IGG_IGA_V3",
            "MA_IGG_IGA_V3",
            "HSV2_IGG_IGA_V3",
            "EBV_IGG_IGA_V3",
            "CMV_IGG_IGA_V3",
            "HHV_6__IGG_IGA_V3",
            "HHV_7__IGG_IGA_V3",
            "STREPTOCOCCAL_A_IGG_IGA_V3",
            "TUBULIN_IGM_V3",
            "MYELIN_BASIC_IGM_V3",
            "MYELIN_OLIGODENDROCYTE_GLYCOIGM_V3",
            "MYELIN_PROTEOLIPID_IGM_V3",
            "NEUROFASCIN_IGM_V3",
            "MAG_IGM_V3",
            "S100B_IGM_V3",
            "GLIAL_FIBRILLARY_ACIDIC_IGM_V3",
            "MICROGLIA_IGM_V3",
            "GLUCOSE_REGULATED_78_IGM_V3",
            "NEURON_SPECIFIC_ENOLASE_IGM_V3",
            "AQUAPORIN4_IGM_V3",
            "RECOVERIN_IGM_V3",
            "CV2_IGM_V3",
            "GM1_IGM_V3",
            "GM2_IGM_V3",
            "HU_IGM_V3",
            "RI_IGM_V3",
            "AMPHIPHYSIN_IGM_V3",
            "ACETYLCHOLINE_R_IGM_V3",
            "MUSCLE_SPECIFIC_KINASE_IGM_V3",
            "VOLTAGE_GATED_CALCIUM_IGM_V3",
            "VOLTAGE_GATED_POTASSIUM_IGM_V3",
            "TITIN_IGM_V3",
            "HSV1_IGM_V3",
            "CEREBELLUM_IGM_V3",
            "PURKINJE_CELL_IGM_V3",
            "YO_IGM_V3",
            "AMYLOID_BETA__25_35__IGM_V3",
            "AMYLOID_BETA__1_42__IGM_V3",
            "RAGE_PEPTIDE_IGM_V3",
            "TAU_IGM_V3",
            "GLUTAMATE_IGM_V3",
            "DOPAMINE_IGM_V3",
            "HYDROXYTRYPTAMINE_IGM_V3",
            "ALPHA_SYNUCLEIN_IGM_V3",
            "A1_AND_B2_ADRENERGIC_R_IGM_V3",
            "ENDOTHELIN_A_RECEPTOR_IGM_V3",
            "NMDA_RECEPTOR_IGM_V3",
            "AMPA_RECEPTOR_IGM_V3",
            "DOPAMINE_RECEPTOR_1_IGM_V3",
            "DOPAMINE_RECEPTOR_2_IGM_V3",
            "GABA_R_IGM_V3",
            "DIPEPTIDYL_AMINOPEPTIDASE_6_IGM_V3",
            "GLYCINE_RECEPTOR_IGM_V3",
            "NEUREXIN_3_IGM_V3",
            "CONTACTIN_ASSOCIATED_2_IGM_V3",
            "LEUCINE_RICH_GLIOMA_1__LGI1__IGM_V3",
            "MA_IGM_V3",
            "HSV2_IGM_V3",
            "EBV_IGM_V3",
            "CMV_IGM_V3",
            "HHV_6__IGM_V3",
            "HHV_7__IGM_V3",
            "STREPTOCOCCAL_A_IGM_V3"
        };

        // class , protein , info_id ,squences ,gene
        conditions = new NeuralCondition[testcode.length / 2];
        conditions[0] = new NeuralCondition("" , ".*tubulin.*" , "" , "", "");
        conditions[1] = new NeuralCondition("" , ".*myelin.*basic.*" , "" , "" , "");
        conditions[2] = new NeuralCondition("" , ".*myelin.*oligo.*" , "" , "", "");
        conditions[3] = new NeuralCondition("" , "" , "" , "DIQRIPSLPPSTQTLKLIETHLRTI%QTLKLIETHLRTIPSHAFSNLPNIS", "");
        conditions[4] = new NeuralCondition("" , ".*neurofascin.*" , "" , "", "");
        conditions[5] = new NeuralCondition("" , "" , "" , "SLPPSTQTLKLIETHLRTIPSHAFS%QTLKLIETHLRTIPSHAFSNLPNIS", "");
        conditions[6] = new NeuralCondition("" , ".*s100-B.*" , "" , "", "");
        conditions[7] = new NeuralCondition("" , ".*glial.*" , "" , "", "");
        conditions[8] = new NeuralCondition("" , "" , "" , "AHLRVTAAPQSVCALRAVDQSVLLM%ANKVDLSFSPSQSLPASHAHLRVTA%DIDANGIVHVSAKDKGTGREQQIVI%GPVEIVVRSPTPLNDDQWHRVTAER%GVPQIEVTFEIDVNGILRVTAEDKG%HRVTAERNVKQASLQVDRLPQQIRK%IPPAPRGVPQIEVTFEIDVNGILRV%IVHVSAKDKGTGREQQIVIQSSGGL%KDKGTGREQQIVIQSSGGLSKDDIE", "");
        conditions[9] = new NeuralCondition("" , "" , "" , "LNDDQWHRVTAERNVKQASLQVDRL%QIEVTFDIDANGIVHVSAKDKGTGR%SFSPSQSLPASHAHLRVTAAPQSVC%SLPASHAHLRVTAAPQSVCALRAVD%TFDLTGIPPAPRGVPQIEVTFEIDV%VNGILRVTAEDKGTGNKNKITITND%VRSPTPLNDDQWHRVTAERNVKQAS%VTAEDKGTGNKNKITITNDQNRLTP%VTFEIDVNGILRVTAEDKGTGNKNK", "");
        conditions[10] = new NeuralCondition("" , ".*enolase.*" , "" , "", "");
        conditions[11] = new NeuralCondition("" , ".*aquaporin.*" , "" , "", "");
        conditions[12] = new NeuralCondition("" , "" , "" , "AGDTHLGGEDFDNRLVNHFVEEFKR%AGDTHLGGEDFDNRMVNHFIAEFKR%ALQNSLGGEDSDARVEAAATWYYSL%DVSILTIDDGIFEVKATAGDTHLGG%EESRGRTSSKTAFYQALQNSLGGED%EVKATAGDTHLGGEDFDNRLVNHFV%FDVSILTIDDGIFEVKATAGDTHLG%FDVSILTIEDGIFEVKSTAGDTHLG%FEVKATAGDTHLGGEDFDNRLVNHF%FEVKSTAGDTHLGGEDFDNRMVNHF%FYQALQNSLGGEDSDARVEAAATWY%GDTHLGGEDFDNRLVNHFVEEFKRK%GGEDFDNRLVNHFVEEFKRKHKKDI%GGEDFDNRMVNHFIAEFKRKHKKDI%IDDGIFEVKATAGDTHLGGEDFDNR%KGVFEVKSTNGDTFLGGEDFDQALL%KSTNGDTFLGGEDFDQALLRHIVKE%KTAFYQALQNSLGGEDSDARVEAAA%KYGVRTGHPRFFNQLSTGLDIIGLA%LGGEDFDQRVMEHFIKLYKKKTGKD%LTIDNGVFEVVATNGDTHLGGEDFD%LVDCRDTLKYGVRTGHPRFFNQLST%MHCQTTLKYAIKTGHPRYFNQLSTG%NQLSTGLDIIGLAGEWLTSTANTNM%NSLGGEDSDARVEAAATWYYSLEHS%PRFFNQLSTGLDIIGLAGEWLTSTA%RDTLKYGVRTGHPRFFNQLSTGLDI%RGRTSSKTAFYQALQNSLGGEDSDA%RTGHPRFFNQLSTGLDIIGLAGEWL%RYFNQLSTGLDMVGLAADWLTSTAN%SILEIQKGVFEVKSTNGDTFLGGED%TFDVSLLTIDNGVFEVVATNGDTHL%TFLGGEDFDQALLRHIVKEFKRETG", "");
        conditions[13] = new NeuralCondition("" , "" , "" , "TGHPRYFNQLSTGLDMVGLAADWLT%TIDDGIFEVKATAGDTHLGGEDFDN%TIEDGIFEVKSTAGDTHLGGEDFDN%TNGDTHLGGEDFDQRVMEHFIKLYK%TSSKTAFYQALQNSLGGEDSDARVE%TTLKYAIKTGHPRYFNQLSTGLDMV%VFEVVATNGDTHLGGEDFDQRVMEH%YAIKTGHPRYFNQLSTGLDMVGLAA%ZZZKTGHPRYFNQLSTGLDMVGLZZ%ZZZRYFNQLSTGLDMVGLAADWLZZ%ZZZTHLGGEDFDNRLVNHFVEEFZZ%ZZZTIDDGIFEVKATAGDTHLGGZZ%ZZZZZHPRYFNQLSTGLDMVGZZZZ%ZZZZZTGHPRYFNQLSTGLDZZZZZ%ZZZZZZZGHPRYFNQLSTGZZZZZZ%ZZZZZZZZHPRYFNQLSTZZZZZZZ", "");
        conditions[14] = new NeuralCondition("" , ".*Envelope glycoprotein M.*%.*Envelope glycoprotein L.*%.*Envelope glycoprotein H.*%.*Envelope glycoprotein C.*" , "" , "", "");
        conditions[15] = new NeuralCondition("" , ".*Envelope glycoprotein B.*%.*Envelope glycoprotein K.*%.*Envelope glycoprotein D.*%.*Envelope glycoprotein G.*" , "" , "", "");
        conditions[16] = new NeuralCondition("" , "" , "" , "APCRSERLAKYNQLLRIEEELGSKA%AWTAPSTSQKCDEPLVSGLPHVAFS%EPLVSGLPHVAFSSSSSISGSYSPG%GQIKTGAPCRSERLAKYNQLLRIEE%KTGAPCRSERLAKYNQLLRIEEELG%KYNQLLRIEEELGSKAKFAGRNFRN%LCTGQIKTGAPCRSERLAKYNQLLR", "");
        conditions[17] = new NeuralCondition("" , "" , "" , "LLEAAPSGSGLPKPADCLLAQDLCW%LSEISKLLEAAPSGSGLPKPADCLL%RLAKYNQLLRIEEELGSKAKFAGRN%RSERLAKYNQLLRIEEELGSKAKFA%SGSGLPKPADCLLAQDLCWELLASG%TSQKCDEPLVSGLPHVAFSSSSSIS%VGLGDPLSEISKLLEAAPSGSGLPK", "");
        conditions[18] = new NeuralCondition("" , "" , "" , "%TYNQL.*%.*YNQLF.*%.*NQLFK.*%.*QLFKR.*%.*LFKRQ.*%.*FKRQE.*%.*KRQEA.*%.*RQEAE.*%.*QEAEG.*%.*EAEGT.*%.*AEGTR.*%.*EGTRL.*%.*GTRLQ%\"", "");
        conditions[19] = new NeuralCondition("" , "%acetylcholine%" , "" , "", "");
        conditions[20] = new NeuralCondition("" , "%kinase%muscle%" , "" , "", "");
        conditions[21] = new NeuralCondition("" , "%voltage%calcium%" , "" , "", "");
        conditions[22] = new NeuralCondition("" , "%voltage%potassium%" , "" , "", "");
        conditions[23] = new NeuralCondition("" , "" , "" , ".*TYNQL.*%.*NQLE.*%.*NLES.*%.*LESD.*%.*LESDP.*%.*ESDPI.*%.*SDPIV.*%.*DPIVA.*%.*PIVAQ.*%.*IVAQY.*", "");
        conditions[24] = new NeuralCondition("" , ".*Envelope glycoprotein N.*%.*Envelope glycoprotein I.*%.*Envelope glycoprotein J.*%.*Envelope glycoprotein E.*" , "" , "", "");
        conditions[25] = new NeuralCondition("" , ".*purkinje cell protein 4.*" , "" , "", "");
        conditions[26] = new NeuralCondition("" , ".*purkinje cell protein 2.*" , "" , "", "");
        conditions[27] = new NeuralCondition("" , "" , "" , "DIYKERSDDFKRDSVSGGGPCTNRS%DRGGGPAEGSAGPPAALPQQTATPE%DSVSGGGPCTNRSHIKHGTGDKHGV%EAEDLQVGQVELGGGPGAGSLQPLA%EAESGAEPGGGPRPRRPLLLPNLSP%EPGGGPRPRRPLLLPNLSPARPRGS%FYTPKTRREAEDLQVGQVELGGGPG%GGGPGAGSLQPLALEGSLQKRGIVE%GSSSDKTLPSITEAESGAEPGGGPR%KTRREAEDLQVGQVELGGGPGAGSL", "");
        conditions[28] = new NeuralCondition("" , ".*amyloid.*" , "" , "" , "IAPP");
        conditions[29] = new NeuralCondition("" , ".*amyloid.*" , "" , "", "");
        conditions[30] = new NeuralCondition("" , "" , "" , "LQVGQVELGGGPGAGSLQPLALEGS%PGGAGFSGYPQPPSQSYGGGPAQVP%PSQSYGGGPAQVPLPGGFPGGQMPS%QVELGGGPGAGSLQPLALEGSLQKR%SDDFKRDSVSGGGPCTNRSHIKHGT%SGYPQPPSQSYGGGPAQVPLPGGFP%SQGPKGEGDRGGGPAEGSAGPPAAL%TLAQPSTSSQGPKGEGDRGGGPAEG%TLPSITEAESGAEPGGGPRPRRPLL%VCGERGFFYTPKTRREAEDLQVGQVELGGG", "");
        conditions[31] = new NeuralCondition("" , "" , "" , "ZZZGGGPGAGSLQPLALEGSLQKZZ%ZZZZGQVELGGGPGAGSLQPLZZZZ%ZZZZREAEDLQVGQVELGGGPZZZZ%ZZZZVGQVELGGGPGAGSLQPZZZZ%ZZZZZEDLQVGQVELGGGPGAZZZZ%ZZZZZGQVELGGGGIVEQCCZZZZZ%ZZZZZGQVELGGGNAVEVLKZZZZZ%ZZZZZGQVELGGGSSPETLIZZZZZ%ZZZZZGQVELGGGTPIESHQZZZZZ%ZZZZZLQVELGGGPGAGSLQZZZZZ", "");
        conditions[32] = new NeuralCondition("" , ".*glutamate.*" , "" , "", "");
        conditions[33] = new NeuralCondition("" , ".*dopamine.*" , "" , "", "");
        conditions[34] = new NeuralCondition("" , "" , "" , ".*DYVNK.*%.*YVNKR.*%.*VNKRT.*%.*NKRTP.*%.*KRTPR.*%.*RTPRR.*%.*TPRR.*%.*PRR.*", "");
        conditions[35] = new NeuralCondition("" , "" , "" , ".*GLEEQ.*%.*LEEQK.*%.*EEQKL.*%.*EQKLI.*%.*QKLIS.*%.*KLISE.*%.*LISEE.*%.*ISEED.*%.*SEEDL.*%.*EEDLG.*%.*EDLGS.*%.*DLGSG.*%.*LGSGS.*", "");
        conditions[36] = new NeuralCondition("" , ".*adrenergic.*" , "" , "", "");
        conditions[37] = new NeuralCondition("" , "" , "" , ".*GLEEQ.*%.*LEEQK.*%.*EEQKL.*%.*EQKLI.*%.*QKLIS.*%.*KLISE.*%.*LISER.*%.*ISERK.*%.*SERKK.*%.*ERKKS.*%.*RKKSG.*%.*KKSGM.*%.*KSGMQ.*%.*SGMQI.*%.*GMQIA.*%.*MQIAL.*%.*QIALN.*%.*IALND.*%.*ALNDH.*%.*LNDHL.*%.*NDHLK.*%.*DHLKQ.*", "");
        conditions[38] = new NeuralCondition("" , ".*NMDA.*" , "" , "", "");
        conditions[39] = new NeuralCondition("" , "" , "" , ".*RFVPF.*%.*FVPFS.*%.*VPFSD.*%.*PFSDQ.*%.*FSDQQ.*%.*SDQQI.*%.*DQQIS.*%.*QQISN.*%.*QISND.*%.*ISNDS.*%.*SNDSA.*%.*NDSAS.*%.*DSASS.*%.*SASSE.*%.*ASSEN.*", "");
        conditions[40] = new NeuralCondition("" , ".*dopamine.*" , "" , "", "");
        conditions[41] = new NeuralCondition("" , ".*isoform 2.*dopamine.*" , "" , "", "");
        conditions[42] = new NeuralCondition("" , "" , "" , "AWILLLSTLTGRSYGQPSLQDELKD%DNTTVFTRILDRLLDGYDNRLRPGL%ETLPELKDDKDFTGTVHRIDNTTVI%IDNTTVIYNSNIFTDPFFIVETLCI%KDDKDFTGTVHRIDNTTVIYNSNIF", "");
        conditions[43] = new NeuralCondition("" , ".*aminopeptidase.*" , "" , "", "");
        conditions[44] = new NeuralCondition("" , ".*glycine.*receptor.*" , "" , "", "");
        conditions[45] = new NeuralCondition("" , ".*neurexin.*" , "" , "", "");
        conditions[46] = new NeuralCondition("" , ".*contactin.*" , "" , "", "");
        conditions[47] = new NeuralCondition("" , ".*leucine.*" , "" , "", "");
        conditions[48] = new NeuralCondition("" , "" , "" , "LQDELKDNTTVFTRILDRLLDGYDN%STLTGRSYGQPSLQDELKDNTTVFT%SYGQPSLQDELKDNTTVFTRILDRL%TGTVHRIDNTTVIYNSNIFTDPFFI%ZZZZZQPSQDELKDNTTVFTZZZZZ", "");
        conditions[49] = new NeuralCondition("" , "" , "" , ".*KAYQQ.*%.*AYQQG.*%.*YQQGV.*%.*QQGVT.*%.*QGVTV.*%.*GVTVD.*%.*VTVDS.*%.*TVDSI.*%.*VDSIG.*%.*DSIGM.*%.*SIGML.*%.*IGMLP.*%.*GMLPR.*%.*MLPRF.*%.*LPRFT.*%.*PRFTP.*", "");
        conditions[50] = new NeuralCondition("" , "" , "" , ".*TGGVY.*%.*GGVYH.*%.*GVYHF.*%.*VYHFV.*%.*YHFVK.*%.*HFVKK.*%.*FVKKH.*%.*VKKHV.*%.*KKHVH.*%.*KHVH.*%.*HVH.*", "");
        conditions[51] = new NeuralCondition("" , "" , "" , ".*HEYNW.*%.*EYNWL.*%.*YNWLR.*%.*NWLRS.*%.*WLRSP.*%.*LRSPF.*%.*RSPFS.*%.*SPFSR.*%.*PFSRY.*%.*FSRYS.*%.*SRYSA.*%.*RYSAT.*%.*YSATC.*%.*SATCP.*%.*ATCPN.*%.*TCPNV.*%.*CPNVL.*%.*PNVLH.*", "");
        conditions[52] = new NeuralCondition("" , "" , "" , ".*MDRPR.*%.*DRPRT.*%.*RPRTP.*%.*PRTPP.*%.*RTPPP.*%.*TPPPS.*%.*PPPSY.*%.*PPSYS.*%.*PSYSE.*%.*SYSE.*%.*YSE.*", "");
        conditions[53] = new NeuralCondition("" , "" , "" , ".*HPWT.*%.*PWTE.*%.*PWTET.*%.*TETT.*%.*TETTI.*%.*ETTIE.*%.*TTIEP.*%.*TIEPW.*%.*IEPWR.*%.*EPWRD.*%.*PWRDI.*%.*WRDID.*", "");
        conditions[54] = new NeuralCondition("" , "" , "" , ".*ASVKV.*%.*SVKVL.*%.*VKVLL.*%.*KVLLG.*%.*VLLGR.*%.*LLGRK.*%.*LGRKS.*%.*GRKSD.*%.*RKSDS.*%.*KSDSE.*%.*SDSER.*%.*DSERG.*", "");
    }
    //loc_sample_map :  test_name , pillarId ,julien Barcode
    public static  Map<Integer , Integer >  getAgeMap(Map<String, String[]> loc_sample_map) throws SQLException, Exception{
        Map<Integer , Integer > ageMap = new HashMap();
        List<Integer> julienBarcodeList = new ArrayList();
        for(String[] julienInfo : loc_sample_map.values()){
            julienBarcodeList.add(Integer.parseInt(julienInfo[1]));
        }     
        DataBaseCon db = new LXDataBaseCon();
        String sql = "select patient_barcode_internal as julien_barcode ,DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(patient_birthdate, '%Y') AS Age from \n" +
"vibrant_america_information.patient_details where patient_barcode_internal in("+StringOperation.getSampleSql(julienBarcodeList)  +");";
//        System.out.println(sql);
        ResultSet rs = db.read(sql);
        while(rs.next()){
            ageMap.put(rs.getInt(1) , rs.getInt(2));    
        }
        db.close();            
        return ageMap;
    }
    
    
    
    //Map<test , Map<location , unit>>
    public static Map<String, Map<String, Float>> getNeuralUnitData(Map<String, Map<String, List<Float>>> map_raw ,
                                                                    Map<String, List<Float>> negative_map , 
                                                                    Map<String, String[]> loc_sample_map) throws SQLException, Exception{
        Map<String, Map<String, Float>> unitMap = new LinkedHashMap();
        NeuralZoomer zoomer = new NeuralZoomer();
        String[] testcode = zoomer.getTestCode();
        for(int i = 0 ; i < testcode.length ; i++)unitMap.put(testcode[i] , new HashMap());
        
        List<Integer> julienBarcodeList = new ArrayList();
        //julien _barcode : age
        Map<Integer , Integer > ageMap = new HashMap();
        
        for(String[] julienInfo : loc_sample_map.values()){
            julienBarcodeList.add(Integer.parseInt(julienInfo[1]));
        }
        if(julienBarcodeList.size() > 5){
            
            DataBaseCon db = new LXDataBaseCon();
            String sql = "select patient_barcode_internal as julien_barcode ,DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(patient_birthdate, '%Y') AS Age from \n" +
"vibrant_america_information.patient_details where patient_barcode_internal in("+StringOperation.getSampleSql(julienBarcodeList)  +");";
            ResultSet rs = db.read(sql);
            while(rs.next()){
                ageMap.put(rs.getInt(1) , rs.getInt(2));    
            }
            db.close();            
        }
        
        
        for (String test : map_raw.keySet()) {
            for (String location : map_raw.get(test).keySet()) {
                List<Float> list = map_raw.get(test).get(location);
                String[] testArr = test.split("_");
                String type = testArr[testArr.length - 2].equals("IGA")? "igg" : "iga";
                float avg_raw = Math_Tool.findMedian(list);
                float avg_neg = Math_Tool.findMedian(negative_map.get(location + "_" + type));
                float unit = avg_raw / avg_neg;
                if(unit > 1000) unit = 1; 
                unitMap.get(test).put(location,unit);
                
            }
        }
        
        
        Map<String , Integer> test2IndexMap = new HashMap();
        
        for(int i = 0 ; i < testcode.length ; i++) test2IndexMap.put(testcode[i] , i);
        
        
 
        for(String testCode : unitMap.keySet()){
            List<Double> list = new ArrayList();
            for(String loc : unitMap.get(testCode).keySet()){
                if(!ageMap.containsKey(loc_sample_map.get(loc)[1]))continue;
                int curAge = ageMap.get(loc_sample_map.get(loc)[1]);
                if(curAge >= testAgeRange[test2IndexMap.get(testCode)][0] && curAge <= testAgeRange[test2IndexMap.get(testCode)][1]){
                    list.add((double)unitMap.get(testCode).get(loc));
                }
            }
            if(list.size() < 5){
                list.clear();
                for(float val : unitMap.get(testCode).values()) list.add((double)val);
            }
            
            HashSet<Double> set = new HashSet(list);
            double[] arr = new double[set.size()];
            Iterator<Double> it = set.iterator();
            int index = 0;
            while(it.hasNext()){
                arr[index++] = it.next();
            }
//            for(int i = 0 ; i < set.size() ; i++){
//                arr[i] = list.get(i);
//            } 
            
            double[] p = testPercentile[test2IndexMap.get(testCode)];
            double x1 = Math_Tool.getPercentile(arr , p[0]);
            double x2 = Math_Tool.getPercentile(arr , p[1]);
            
//            System.out.println(Arrays.toString(arr));
//            System.out.println(x1 + " percentile  " + x2);
            
            double a = 10 / (x2 - x1);
            double b = 10 - x1 * a;
            
            
            
            
            for(String loc : unitMap.get(testCode).keySet()){
                float pre =  unitMap.get(testCode).get(loc);
                float unit = (float)(pre * a + b) < 0 ? (float)(Math.random() * 8) : (float)(pre * a + b);
                unit = unit > 30 ? 30 : unit;
//                System.out.println(unit);
               
                unitMap.get(testCode).put(loc, unit);
            }
        }
        
//        
//        for(String testCode : unitMap.keySet()){
//            for(String loc : unitMap.get(testCode).keySet()){
//                System.out.println(testCode + "   " + loc + "  " + unitMap.get(testCode).get(loc));
//            }
//        }
        return unitMap;
    }
    // location  m, floatG ,floatA      // testCode , location
    public static Map< String , float[]> getCF(Map<String, Map<String, Float>>  unitMap){
        Map<String , float[]>  cfMap = new HashMap();
        Map<String , List<Float>>  locUnitMap = new HashMap();
        for(String testCode : unitMap.keySet()){
            for(String loc : unitMap.get(testCode).keySet()){
                cfMap.putIfAbsent(loc, new float[]{1f , 1f});
                String[] arr = testCode.split("_");
                String key = loc + ":" + arr[arr.length - 2];
                locUnitMap.computeIfAbsent( key, x -> new ArrayList()).add(unitMap.get(testCode).get(loc));
            }
        }
        
        
        
        for(String locATestCode : locUnitMap.keySet()){
            String[] arr = locATestCode.split(":");
            int index = arr[1].equals("IGA") ? 0 : 1;
            float cf = 1f;
            List<Float> list = locUnitMap.get(locATestCode);
            int ctPos = 0;
            for(float tmp : list){
                if(tmp > 10) ++ctPos;
            } 
            if(index == 0){
                while(ctPos > 15 ){
         
                    cf += 0.1f;
                    ctPos = 0;
                    for(float tmp : list){
                        if(tmp / cf > 10) ++ctPos;
                    } 
                }
                while(ctPos < 2 ){
               
                    cf -= 0.1f;
                    ctPos = 0;
                    for(float tmp : list){
                        if(tmp / cf > 10) ++ctPos;
                    } 
                }
                
            }else{
                while(ctPos > 6 ){
                  
                    cf += 0.1f;
                    ctPos = 0;
                    for(float tmp : list){
                        if(tmp / cf > 10) ++ctPos;
                    } 
                }
                while(ctPos < 0 ){
                 
                    cf -= 0.1f;
                    ctPos = 0;
                    for(float tmp : list){
                        if(tmp / cf > 10) ++ctPos;
                    } 
                }
            }
            cfMap.get(arr[0])[index] = cf;
        }
        
//        for(String loc : cfMap.keySet()){
//            System.out.println(loc + "   " + Arrays.toString(cfMap.get(loc)));
//        }
        
        return cfMap;
    
    }
    
    
    //loc_sample_map :  test_name , pillarId ,julien Barcode
    
    
    public static Map<String , NeuralDupData> getDupUnitData( Map<String, String[]> loc_sample_map) throws SQLException, Exception{
        Map<String , NeuralDupData> mapUnit = new HashMap();
        
        Map<String ,String> oldTest2NewTest = new HashMap();
        oldTest2NewTest.put("ANTI_TUBUL_IGM_V2" , "TUBULIN_IGM_V3");
        oldTest2NewTest.put("ANTI_TUBUL_IGG_IGA_V2" , "TUBULIN_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_S100B_IGM_V2" , "S100B_IGM_V3");
        oldTest2NewTest.put("ANTI_S100B_IGG_IGA_V2" , "S100B_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_PURKI_CEL_IGM_V2" , "PURKINJE_CELL_IGM_V3");
        oldTest2NewTest.put("ANTI_PURKI_CEL_IGG_IGA_V2" , "PURKINJE_CELL_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_NEURO_SPE_ENO_IGM_V2" , "NEURON_SPECIFIC_ENOLASE_IGM_V3");
        oldTest2NewTest.put("ANTI_NEURO_SPE_ENO_IGG_V2" , "NEURON_SPECIFIC_ENOLASE_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_MYELI_BAS_PRO_IGM_V2" , "MYELIN_BASIC_IGM_V3");
        oldTest2NewTest.put("ANTI_MYELI_BAS_PRO_IGG_V2" , "MYELIN_BASIC_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_HSV1_IGM_V2" , "HSV1_IGM_V3");
        oldTest2NewTest.put("ANTI_HSV1_IGG_IGA_V2" , "HSV1_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_GM2_IGM_V2" , "GM2_IGM_V3");
        oldTest2NewTest.put("ANTI_GM2_IGG_IGA_V2" , "GM2_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_GM1_IGM_V2" , "GM1_IGM_V3");
        oldTest2NewTest.put("ANTI_GM1_IGG_IGA_V2" , "GM1_IGG_IGA_V3");
        oldTest2NewTest.put("ANTI_CEREB_IGM_V2" , "CEREBELLUM_IGM_V3");
        oldTest2NewTest.put("ANTI_CEREB_IGG_IGA_V2" , "CEREBELLUM_IGG_IGA_V3");
        
        
        
        
        
        List<Integer> julienList = new ArrayList();
        for(String[] info : loc_sample_map.values()){
            julienList.add(Integer.parseInt(info[1]));
        }
        
        
        
        
        
        Map<String , String> old2NewMap1 = new HashMap();
        
        String sqlJu = StringOperation.getSampleSql(julienList).toString();

        //check v3
        DataBaseCon db = new LXDataBaseCon();
        String sqlDupV3 = "SELECT\n" +
"   group_concat(sd.julien_barcode order by sd.julien_barcode desc) as julien\n" +
"FROM\n" +
"    vibrant_america_information.`patient_details` pd\n" +
"        JOIN\n" +
"    vibrant_america_information.`sample_data` sd ON sd.`patient_id` = pd.`patient_id`\n" +
"        JOIN\n" +
"    vibrant_america_information.`customers_of_patients` cop ON cop.`patient_id` = sd.`patient_id`\n" +
"        AND cop.`customer_id` = sd.`customer_id`\n" +
"        join\n" +
"          vibrant_america_information.`customer_details` cd on  cd.customer_id = sd.customer_id\n" +
"        AND cop.`customer_id` = sd.`customer_id`\n" +
"        join vibrant_america_information.selected_test_list slt on slt.sample_id = sd.sample_id\n" +
"        join `vibrant_america_test_result`.`result_neural_zoomer_v3_panel1` rwp on rwp.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.order_neural_zoomer_v3_panel1 != 0 \n" +
"   group by PD.PATIENT_ID having count(*)>=2 and julien REGEXP '"+ sqlJu.replaceAll(",", "|")  +"'   order by substring(group_concat(sd.julien_barcode order by sd.julien_barcode desc),1,10) desc;";
        System.out.println(sqlDupV3);
        ResultSet rsDupV3 = db.read(sqlDupV3);
      
        while(rsDupV3.next()){
            String[] tmp = rsDupV3.getString(1).split(",");
            old2NewMap1.putIfAbsent(tmp[1], tmp[0]);
        }
      
        
        List<Integer> v3JulienList = new ArrayList();
        for(String tmp : old2NewMap1.keySet()) v3JulienList.add(Integer.parseInt(tmp));
        
//        System.out.println("old2NewMap1" + old2NewMap1);
//        System.out.println("v3JulienList" + v3JulienList);
        if(!v3JulienList.isEmpty()){
            String sqlDataV3 = 
    "select julien_barcode , a.* , b.* ,c.* ,d.* from vibrant_america_information.sample_data as sd join\n" +
    "`vibrant_america_test_result`.result_neural_zoomer_v3_panel1 as a on sd.sample_id = a.sample_id join\n" +
    "`vibrant_america_test_result`.result_neural_zoomer_v3_panel2 as b on a.sample_id = b.sample_id join\n" +
    "`vibrant_america_test_result`.result_neural_zoomer_v3_panel3 as c on a.sample_id = c.sample_id join\n" +
    "`vibrant_america_test_result`.result_neural_zoomer_v3_panel4 as d on a.sample_id = d.sample_id\n" +
    " where julien_barcode in ("+ StringOperation.getSampleSql(v3JulienList).toString() +");";
           
            ResultSet rsDataV3 = db.read(sqlDataV3);
            
            int col = rsDataV3.getMetaData().getColumnCount();
            while(rsDataV3.next()){
                 Map<String ,Float> curMap = new HashMap();
                 String oldJulien = rsDataV3.getString(1);
                 String newJulien = old2NewMap1.get(oldJulien);
                 for(int i = 2 ; i <= col ; i++){
                     String label = rsDataV3.getMetaData().getColumnLabel(i);
                     if(label.startsWith("DOPAMINE_R"))continue;
                     if(label.equals("sample_id")) continue;
                     curMap.put(label , rsDataV3.getFloat(i));
                 }
                 mapUnit.put(newJulien , new NeuralDupData(oldJulien , curMap));
            }
            
        }
        
        
        // check v2
        Map<String ,String> old2NewMap2 = new HashMap();
        String sqlDupV2 = "SELECT\n" +
"   group_concat(sd.julien_barcode order by sd.julien_barcode desc) as julien\n" +
"FROM\n" +
"    vibrant_america_information.`patient_details` pd\n" +
"        JOIN\n" +
"    vibrant_america_information.`sample_data` sd ON sd.`patient_id` = pd.`patient_id`\n" +
"        JOIN\n" +
"    vibrant_america_information.`customers_of_patients` cop ON cop.`patient_id` = sd.`patient_id`\n" +
"        AND cop.`customer_id` = sd.`customer_id`\n" +
"        join\n" +
"          vibrant_america_information.`customer_details` cd on  cd.customer_id = sd.customer_id\n" +
"        AND cop.`customer_id` = sd.`customer_id`\n" +
"        join vibrant_america_information.selected_test_list slt on slt.sample_id = sd.sample_id\n" +
"        join `vibrant_america_test_result`.`result_wellness_panel25` rwp on rwp.sample_id = sd.sample_id \n" +
"WHERE\n" +
"   slt.Order_Wellness_Panel25 != 0\n" +
"   group by PD.PATIENT_ID having count(*)>=2 and julien REGEXP '"+ sqlJu.replaceAll(",", "|") +"' order by substring(group_concat(sd.julien_barcode order by sd.julien_barcode desc),1,10) desc;";
        System.out.println(sqlDupV2);
        ResultSet rsDupV2 = db.read(sqlDupV2);
       
        while(rsDupV2.next()){
            String[] tmp = rsDupV2.getString(1).split(",");
            old2NewMap2.putIfAbsent(tmp[1], tmp[0]);
        }
        
        
        List<Integer> v2JulienList = new ArrayList();
        
        for(String tmp : old2NewMap2.keySet()) v2JulienList.add(Integer.parseInt(tmp));
        
//        System.out.println("old2NewMap2" + old2NewMap2);
//        System.out.println("v2JulienList" + v2JulienList);
        if(!v2JulienList.isEmpty()){
            String sqlDataV2 = "select julien_barcode , a.*  from vibrant_america_information.sample_data as sd join\n" +
    "`vibrant_america_test_result`.`result_wellness_panel25` as a on sd.sample_id = a.sample_id\n" +
    " where julien_barcode in ("+ StringOperation.getSampleSql(v2JulienList).toString() +");";
            ResultSet rsDataV2 = db.read(sqlDataV2);
            
            int col = rsDataV2.getMetaData().getColumnCount();
            while(rsDataV2.next()){
                 Map<String ,Float> curMap = new HashMap();
                 String oldJulien = rsDataV2.getString(1);
                 String newJulien = old2NewMap2.get(oldJulien);
                 for(int i = 2 ; i <= col ; i++){
                     String label = rsDataV2.getMetaData().getColumnLabel(i);
                     if(label.equals("sample_id")) continue;
                     curMap.put(oldTest2NewTest.get(label) , rsDataV2.getFloat(i));
                 }
                 mapUnit.put(newJulien , new NeuralDupData(oldJulien , curMap));
            }
            
        }
        
//        for(String julien : mapUnit.keySet() ){
//            System.out.println(julien + "   " +mapUnit.get(julien).getJulienBarcode());
//            System.out.println(mapUnit.get(julien).getUnitMap());
//        }
        db.close();
        return mapUnit;
    }
    
    
    
}

