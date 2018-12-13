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
public class NeuralZoomer extends Zoomer {

    private static float qcArr[] = new float[]{2.1f, 3.9f, 1.05f};
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
        
        
        
        double[][] equation_parameter = new double[][]{{0.0153837444252046, -42.6088409842669},
        {0.0254571355751231, -72.9300022476002},
        {0.0383951832084483, -113.001769507023},
        {0.0180241767744716, -50.659106996773},
        {0.0182097740440606, -51.9955400073849},
        {0.0202341129523759, -58.7842980136031},
        {0.0241616217416751, -68.4951611413459},
        {0.0683093991823195, -189.529376501088},
        {0.0208552205904058, -58.4921580442905},
        {0.0317959934940938, -89.7868593002707},
        {0.053591180109515, -157.689621249245},
        {0.0365069801332619, -111.16422124855},
        {0.0245865373172698, -72.7591923191006},
        {0.0175522047333345, -47.7394827706274},
        {0.013573630420746, -35.8879027478178},
        {0.0349864245666404, -103.250027677199},
        {0.0134372095005333, -38.1475842706353},
        {0.0158591900113134, -46.6511277609671},
        {0.0147021310368038, -42.7787069143121},
        {0.0237792588605192, -67.8915261463832},
        {0.0351715310200649, -103.186662103448},
        {0.0219652462841736, -60.7983508249309},
        {0.0303280208597754, -81.7831571348138},
        {0.0715706766444752, -207.729223836783},
        {0.0275086522714445, -82.9987618429871},
        {0.0166745783327018, -46.5288509566119},
        {0.0139265277130164, -38.6421923620549},
        {0.113206389453268, -321.042182863561},
        {0.0515059293916753, -125.882704455781},
        {0.11463286119422, -318.178016624334},
        {0.0267804793994959, -72.8426227887584},
        {0.0413436762767816, -111.946677937859},
        {0.0254806589722055, -72.2967295045149},
        {0.0534410538431901, -152.307749978204},
        {0.0152151961920833, -39.7942358758763},
        {0.0265859918138921, -67.480845695429},
        {0.00972004852533338, -25.5634378523668},
        {0.0306829362943066, -87.1951539363975},
        {0.0918127868014328, -280.568864783106},
        {0.0366346345870668, -108.51417200123},
        {0.0430781500764492, -121.803146420465},
        {0.436890650336331, -1293.18444200737}
        };

        for (int i = 0; i < testcode.length; i++) {
            equation_parameter_map.put(testcode[i], equation_parameter[i]);
        }
    }
}
