/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.ExcelOperation;

/**
 *
 * @author Wei Wang
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        String str = "conditions[0] = new Condition(\"\" , \"\" , \"\" , \"\"};";
        
        String str = "where protein_name like \"%tubulin%\"\n" +
"where protein_name like \"%myelin%basic%\"\n" +
"where protein_name like \"%myelin%oligo%\"\n" +
"where sequence in ('DIQRIPSLPPSTQTLKLIETHLRTI','QTLKLIETHLRTIPSHAFSNLPNIS')\n" +
"where protein_name like \"%neurofascin%\"\n" +
"where sequence in ('SLPPSTQTLKLIETHLRTIPSHAFS','QTLKLIETHLRTIPSHAFSNLPNIS')\n" +
"where protein_name like \"%s100-B%\"\n" +
"where protein_name like \"%glial%\"\n" +
"where  sequence in ('AHLRVTAAPQSVCALRAVDQSVLLM','ANKVDLSFSPSQSLPASHAHLRVTA','DIDANGIVHVSAKDKGTGREQQIVI','GPVEIVVRSPTPLNDDQWHRVTAER','GVPQIEVTFEIDVNGILRVTAEDKG','HRVTAERNVKQASLQVDRLPQQIRK','IPPAPRGVPQIEVTFEIDVNGILRV','IVHVSAKDKGTGREQQIVIQSSGGL','KDKGTGREQQIVIQSSGGLSKDDIE')\n" +
"where  sequence in ('LNDDQWHRVTAERNVKQASLQVDRL','QIEVTFDIDANGIVHVSAKDKGTGR','SFSPSQSLPASHAHLRVTAAPQSVC','SLPASHAHLRVTAAPQSVCALRAVD','TFDLTGIPPAPRGVPQIEVTFEIDV','VNGILRVTAEDKGTGNKNKITITND','VRSPTPLNDDQWHRVTAERNVKQAS','VTAEDKGTGNKNKITITNDQNRLTP','VTFEIDVNGILRVTAEDKGTGNKNK')\n" +
"where protein_name like \"%enolase%\"\n" +
"where protein_name like \"%aquaporin%\"\n" +
"where sequence in ('AGDTHLGGEDFDNRLVNHFVEEFKR','AGDTHLGGEDFDNRMVNHFIAEFKR','ALQNSLGGEDSDARVEAAATWYYSL','DVSILTIDDGIFEVKATAGDTHLGG','EESRGRTSSKTAFYQALQNSLGGED','EVKATAGDTHLGGEDFDNRLVNHFV','FDVSILTIDDGIFEVKATAGDTHLG','FDVSILTIEDGIFEVKSTAGDTHLG','FEVKATAGDTHLGGEDFDNRLVNHF','FEVKSTAGDTHLGGEDFDNRMVNHF','FYQALQNSLGGEDSDARVEAAATWY','GDTHLGGEDFDNRLVNHFVEEFKRK','GGEDFDNRLVNHFVEEFKRKHKKDI','GGEDFDNRMVNHFIAEFKRKHKKDI','IDDGIFEVKATAGDTHLGGEDFDNR','KGVFEVKSTNGDTFLGGEDFDQALL','KSTNGDTFLGGEDFDQALLRHIVKE','KTAFYQALQNSLGGEDSDARVEAAA','KYGVRTGHPRFFNQLSTGLDIIGLA','LGGEDFDQRVMEHFIKLYKKKTGKD','LTIDNGVFEVVATNGDTHLGGEDFD','LVDCRDTLKYGVRTGHPRFFNQLST','MHCQTTLKYAIKTGHPRYFNQLSTG','NQLSTGLDIIGLAGEWLTSTANTNM','NSLGGEDSDARVEAAATWYYSLEHS','PRFFNQLSTGLDIIGLAGEWLTSTA','RDTLKYGVRTGHPRFFNQLSTGLDI','RGRTSSKTAFYQALQNSLGGEDSDA','RTGHPRFFNQLSTGLDIIGLAGEWL','RYFNQLSTGLDMVGLAADWLTSTAN','SILEIQKGVFEVKSTNGDTFLGGED','TFDVSLLTIDNGVFEVVATNGDTHL','TFLGGEDFDQALLRHIVKEFKRETG')\n" +
"where sequence in ('TGHPRYFNQLSTGLDMVGLAADWLT','TIDDGIFEVKATAGDTHLGGEDFDN','TIEDGIFEVKSTAGDTHLGGEDFDN','TNGDTHLGGEDFDQRVMEHFIKLYK','TSSKTAFYQALQNSLGGEDSDARVE','TTLKYAIKTGHPRYFNQLSTGLDMV','VFEVVATNGDTHLGGEDFDQRVMEH','YAIKTGHPRYFNQLSTGLDMVGLAA','ZZZKTGHPRYFNQLSTGLDMVGLZZ','ZZZRYFNQLSTGLDMVGLAADWLZZ','ZZZTHLGGEDFDNRLVNHFVEEFZZ','ZZZTIDDGIFEVKATAGDTHLGGZZ','ZZZZZHPRYFNQLSTGLDMVGZZZZ','ZZZZZTGHPRYFNQLSTGLDZZZZZ','ZZZZZZZGHPRYFNQLSTGZZZZZZ','ZZZZZZZZHPRYFNQLSTZZZZZZZ')\n" +
"where (protein_name like '%Envelope glycoprotein M%' or protein_name like '%Envelope glycoprotein L%' or protein_name like '%Envelope glycoprotein H%' or protein_name like '%Envelope glycoprotein C%')\n" +
"where (protein_name like '%Envelope glycoprotein B%' or protein_name like '%Envelope glycoprotein K%' or protein_name like '%Envelope glycoprotein D%' or protein_name like '%Envelope glycoprotein G%')\n" +
"where sequence in ('APCRSERLAKYNQLLRIEEELGSKA','AWTAPSTSQKCDEPLVSGLPHVAFS','EPLVSGLPHVAFSSSSSISGSYSPG','GQIKTGAPCRSERLAKYNQLLRIEE','KTGAPCRSERLAKYNQLLRIEEELG','KYNQLLRIEEELGSKAKFAGRNFRN','LCTGQIKTGAPCRSERLAKYNQLLR')\n" +
"where sequence in ('LLEAAPSGSGLPKPADCLLAQDLCW','LSEISKLLEAAPSGSGLPKPADCLL','RLAKYNQLLRIEEELGSKAKFAGRN','RSERLAKYNQLLRIEEELGSKAKFA','SGSGLPKPADCLLAQDLCWELLASG','TSQKCDEPLVSGLPHVAFSSSSSIS','VGLGDPLSEISKLLEAAPSGSGLPK')\n" +
"where sequence like \"%TYNQL%\" or sequence like \"%YNQLF%\" or sequence like \"%NQLFK%\" or sequence like \"%QLFKR%\" or sequence like \"%LFKRQ%\" or sequence like \"%FKRQE%\" or sequence like \"%KRQEA%\" or sequence like \"%RQEAE%\" or sequence like \"%QEAEG%\" or sequence like \"%EAEGT%\" or sequence like \"%AEGTR%\" or sequence like \"%EGTRL%\" or sequence like \"%GTRLQ%\"\n" +
"where protein_name like \"%acetylcholine%\"\n" +
"where protein_name like \"%kinase%muscle%\"\n" +
"where protein_name like \"%voltage%calcium%\"\n" +
"where protein_name like \"%voltage%potassium%\"\n" +
"where sequence like \"%TYNQL%\" or sequence like \"%NQLE%\" or sequence like \"%NLES%\" or sequence like \"%LESD%\" or sequence like \"%LESDP%\" or sequence like \"%ESDPI%\" or sequence like \"%SDPIV%\" or sequence like \"%DPIVA%\" or sequence like \"%PIVAQ%\" or sequence like \"%IVAQY%\"\n" +
"where (protein_name like '%Envelope glycoprotein N%' or protein_name like '%Envelope glycoprotein I%' or protein_name like '%Envelope glycoprotein J%' or protein_name like '%Envelope glycoprotein E%')\n" +
" where protein_name like \"%purkinje cell protein 4%\" \n" +
" where protein_name like \"%purkinje cell protein 2%\" \n" +
"where sequence in ('DIYKERSDDFKRDSVSGGGPCTNRS','DRGGGPAEGSAGPPAALPQQTATPE','DSVSGGGPCTNRSHIKHGTGDKHGV','EAEDLQVGQVELGGGPGAGSLQPLA','EAESGAEPGGGPRPRRPLLLPNLSP','EPGGGPRPRRPLLLPNLSPARPRGS','FYTPKTRREAEDLQVGQVELGGGPG','GGGPGAGSLQPLALEGSLQKRGIVE','GSSSDKTLPSITEAESGAEPGGGPR','KTRREAEDLQVGQVELGGGPGAGSL')\n" +
"where protein_name like \"%amyloid%\" and gene_name = 'IAPP'\n" +
"where protein_name like \"%amyloid%\"\n" +
"where sequence in ('LQVGQVELGGGPGAGSLQPLALEGS','PGGAGFSGYPQPPSQSYGGGPAQVP','PSQSYGGGPAQVPLPGGFPGGQMPS','QVELGGGPGAGSLQPLALEGSLQKR','SDDFKRDSVSGGGPCTNRSHIKHGT','SGYPQPPSQSYGGGPAQVPLPGGFP','SQGPKGEGDRGGGPAEGSAGPPAAL','TLAQPSTSSQGPKGEGDRGGGPAEG','TLPSITEAESGAEPGGGPRPRRPLL','VCGERGFFYTPKTRREAEDLQVGQVELGGG')\n" +
"where sequence in ('ZZZGGGPGAGSLQPLALEGSLQKZZ','ZZZZGQVELGGGPGAGSLQPLZZZZ','ZZZZREAEDLQVGQVELGGGPZZZZ','ZZZZVGQVELGGGPGAGSLQPZZZZ','ZZZZZEDLQVGQVELGGGPGAZZZZ','ZZZZZGQVELGGGGIVEQCCZZZZZ','ZZZZZGQVELGGGNAVEVLKZZZZZ','ZZZZZGQVELGGGSSPETLIZZZZZ','ZZZZZGQVELGGGTPIESHQZZZZZ','ZZZZZLQVELGGGPGAGSLQZZZZZ')\n" +
"where protein_name like \"%glutamate%\"\n" +
"where protein_name like \"%dopamine%\"\n" +
"where sequence like \"%DYVNK%\" or sequence like \"%YVNKR%\" or sequence like \"%VNKRT%\" or sequence like \"%NKRTP%\" or sequence like \"%KRTPR%\" or sequence like \"%RTPRR%\" or sequence like \"%TPRR%\" or sequence like \"%PRR%\"\n" +
"where sequence like \"%GLEEQ%\" or sequence like \"%LEEQK%\" or sequence like \"%EEQKL%\" or sequence like \"%EQKLI%\" or sequence like \"%QKLIS%\" or sequence like \"%KLISE%\" or sequence like \"%LISEE%\" or sequence like \"%ISEED%\" or sequence like \"%SEEDL%\" or sequence like \"%EEDLG%\" or sequence like \"%EDLGS%\" or sequence like \"%DLGSG%\" or sequence like \"%LGSGS%\"\n" +
"where protein_name like \"%adrenergic%\"\n" +
"where  sequence like \"%GLEEQ%\" or sequence like \"%LEEQK%\" or sequence like \"%EEQKL%\" or sequence like \"%EQKLI%\" or sequence like \"%QKLIS%\" or sequence like \"%KLISE%\" or sequence like \"%LISER%\" or sequence like \"%ISERK%\" or sequence like \"%SERKK%\" or sequence like \"%ERKKS%\" or sequence like \"%RKKSG%\" or sequence like \"%KKSGM%\" or sequence like \"%KSGMQ%\" or sequence like \"%SGMQI%\" or sequence like \"%GMQIA%\" or sequence like \"%MQIAL%\" or sequence like \"%QIALN%\" or sequence like \"%IALND%\" or sequence like \"%ALNDH%\" or sequence like \"%LNDHL%\" or sequence like \"%NDHLK%\" or sequence like \"%DHLKQ%\"\n" +
"where protein_name like \"%NMDA%\"\n" +
"where sequence like \"%RFVPF%\" or sequence like \"%FVPFS%\" or sequence like \"%VPFSD%\" or sequence like \"%PFSDQ%\" or sequence like \"%FSDQQ%\" or sequence like \"%SDQQI%\" or sequence like \"%DQQIS%\" or sequence like \"%QQISN%\" or sequence like \"%QISND%\" or sequence like \"%ISNDS%\" or sequence like \"%SNDSA%\" or sequence like \"%NDSAS%\" or sequence like \"%DSASS%\" or sequence like \"%SASSE%\" or sequence like \"%ASSEN%\"\n" +
"where protein_name like \"%dopamine%\"\n" +
"where protein_name like \"%isoform 2%dopamine%\"\n" +
"where sequence in ('AWILLLSTLTGRSYGQPSLQDELKD','DNTTVFTRILDRLLDGYDNRLRPGL','ETLPELKDDKDFTGTVHRIDNTTVI','IDNTTVIYNSNIFTDPFFIVETLCI','KDDKDFTGTVHRIDNTTVIYNSNIF')\n" +
"where protein_name like \"%aminopeptidase%\"\n" +
"where protein_name like \"%glycine%receptor%\"\n" +
"where protein_name like \"%neurexin%\"\n" +
"where protein_name like \"%contactin%\"\n" +
"where protein_name like \"%leucine%\"\n" +
"where sequence in ('LQDELKDNTTVFTRILDRLLDGYDN','STLTGRSYGQPSLQDELKDNTTVFT','SYGQPSLQDELKDNTTVFTRILDRL','TGTVHRIDNTTVIYNSNIFTDPFFI','ZZZZZQPSQDELKDNTTVFTZZZZZ')\n" +
"where sequence like \"%KAYQQ%\" or sequence like \"%AYQQG%\" or sequence like \"%YQQGV%\" or sequence like \"%QQGVT%\" or sequence like \"%QGVTV%\" or sequence like \"%GVTVD%\" or sequence like \"%VTVDS%\" or sequence like \"%TVDSI%\" or sequence like \"%VDSIG%\" or sequence like \"%DSIGM%\" or sequence like \"%SIGML%\" or sequence like \"%IGMLP%\" or sequence like \"%GMLPR%\" or sequence like \"%MLPRF%\" or sequence like \"%LPRFT%\" or sequence like \"%PRFTP%\"\n" +
"where sequence like \"%TGGVY%\" or sequence like \"%GGVYH%\" or sequence like \"%GVYHF%\" or sequence like \"%VYHFV%\" or sequence like \"%YHFVK%\" or sequence like \"%HFVKK%\" or sequence like \"%FVKKH%\" or sequence like \"%VKKHV%\" or sequence like \"%KKHVH%\" or sequence like \"%KHVH%\" or sequence like \"%HVH%\"\n" +
"where sequence like \"%HEYNW%\" or sequence like \"%EYNWL%\" or sequence like \"%YNWLR%\" or sequence like \"%NWLRS%\" or sequence like \"%WLRSP%\" or sequence like \"%LRSPF%\" or sequence like \"%RSPFS%\" or sequence like \"%SPFSR%\" or sequence like \"%PFSRY%\" or sequence like \"%FSRYS%\" or sequence like \"%SRYSA%\" or sequence like \"%RYSAT%\" or sequence like \"%YSATC%\" or sequence like \"%SATCP%\" or sequence like \"%ATCPN%\" or sequence like \"%TCPNV%\" or sequence like \"%CPNVL%\" or sequence like \"%PNVLH%\"\n" +
"where sequence like \"%MDRPR%\" or sequence like \"%DRPRT%\" or sequence like \"%RPRTP%\" or sequence like \"%PRTPP%\" or sequence like \"%RTPPP%\" or sequence like \"%TPPPS%\" or sequence like \"%PPPSY%\" or sequence like \"%PPSYS%\" or sequence like \"%PSYSE%\" or sequence like \"%SYSE%\" or sequence like \"%YSE%\"\n" +
"where sequence like \"%HPWT%\" or sequence like \"%PWTE%\" or sequence like \"%PWTET%\" or sequence like \"%TETT%\" or sequence like \"%TETTI%\" or sequence like \"%ETTIE%\" or sequence like \"%TTIEP%\" or sequence like \"%TIEPW%\" or sequence like \"%IEPWR%\" or sequence like \"%EPWRD%\" or sequence like \"%PWRDI%\" or sequence like \"%WRDID%\"\n" +
"where sequence like \"%ASVKV%\" or sequence like \"%SVKVL%\" or sequence like \"%VKVLL%\" or sequence like \"%KVLLG%\" or sequence like \"%VLLGR%\" or sequence like \"%LLGRK%\" or sequence like \"%LGRKS%\" or sequence like \"%GRKSD%\" or sequence like \"%RKSDS%\" or sequence like \"%KSDSE%\" or sequence like \"%SDSER%\" or sequence like \"%DSERG%\"";
        System.out.println(str);
//        for(int i = 0 ; i< 55 ;i++){
//            System.out.println("conditions["+i+"] = new Condition(\"\" , \"\" , \"\" , \"\");");
//        }
        
        
    }
    
}
