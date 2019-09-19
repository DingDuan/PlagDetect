package demo.plagdetect.calfeature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CalFileSim {

    private final static String sourceDataRootPath = "/Users/dd/study/iSE/plagiarism_detection/Datalog_clean";

    private final static String diffFileRootPath = "/Users/dd/study/iSE/Graduation-Design/ExperimentResult/Datalog/diff";

    /**
     * @Author duanding
     * @Description 计算两个文件之间的相似度
     * @Date 5:08 PM 2019/9/9
     * @Param [cid1FileLineNumber, cid2FileLineNumber, changeLineNumber]
     * @return double
     **/
    public static double calculateSimValueByDiff(int cid1FileLineNumber
            , int cid2FileLineNumber, int changeLineNumber) {
        double simValueBasedCID1 = 0;
        if (cid1FileLineNumber != 0) {
            int y = cid1FileLineNumber;
            if (changeLineNumber < cid1FileLineNumber) {
                y = changeLineNumber;
            }
            simValueBasedCID1 = 1 - (double) y / cid1FileLineNumber;
        }
        double simValueBasedCID2 = 0;
        if (cid2FileLineNumber != 0) {
            int y = cid2FileLineNumber;
            if (changeLineNumber < cid2FileLineNumber) {
                y = changeLineNumber;
            }
            simValueBasedCID2 = 1- (double) y / cid2FileLineNumber;
        }
        if (simValueBasedCID1 > simValueBasedCID2) {
            return simValueBasedCID1;
        }
        return simValueBasedCID2;
    }

    /**
     * @Author duanding
     * @Description 遍历文件夹跑diff，存diff文件
     * @Date 8:29 AM 2019/9/12
     * @Param [Directory]
     * @return void
     **/
    public static void traverseDirectoryRunDiff(File Directory){
        TerminalExec terminalExec = new TerminalExec();
        File[] cidDirectoryArray = Directory.listFiles();
        int directoryArrayLength = cidDirectoryArray.length;
        //遍历CID1目录
        for(int index1=0;index1<directoryArrayLength;index1++){
            if (index1 != 0) {
                continue;
            }
            File cid1Directory = cidDirectoryArray[index1];
            if (!cid1Directory.isDirectory()) {
                continue;
            }
            String cid1 = cid1Directory.getName();
            System.out.println(cid1);
            //遍历CDI2目录
            for(int index2=index1+1;index2<directoryArrayLength;index2++){
                if (index2 != 1) {
                    continue;
                }
                File cid2Directory = cidDirectoryArray[index2];
                if (!cid2Directory.isDirectory()) {
                    continue;
                }
                String cid2 = cid2Directory.getName();
                System.out.println(cid2);
                File[] cid1TestFileArray = cid1Directory.listFiles();
                File[] cid2TestFileArray = cid2Directory.listFiles();
                StringBuffer buffer = null;
                //遍历CID1,CID2的所有Test文件比较并输出diff文件
                for(File cid1TestFile : cid1TestFileArray){
                    for(File cid2TestFile : cid2TestFileArray){
                        String cid1FileName = cid1TestFile.getName();
                        String cid2FileName = cid2TestFile.getName();
//                        int trueCid1 = index1+1;
//                        int trueCid2 = index2+1;

                        buffer = new StringBuffer(diffFileRootPath + File.separator
                                + cid1 + File.separator + cid2 + File.separator + cid1 + "." + cid1FileName
                                + " vs " + cid2 + "." + cid2FileName + ".txt");
                        File compareFile = new File(buffer.toString());
                        terminalExec.runDiff(cid1TestFile,cid2TestFile,compareFile);
                    }
                }
            }
        }
    }
}
