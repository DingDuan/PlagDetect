package demo.plagdetect.calfeature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CalFileSim {

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

//    public static void traverseDirectoryRunDiff(File Directory)
}
