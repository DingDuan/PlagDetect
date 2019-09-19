package demo.plagdetect.calfeature;

import java.io.File;

public class CalCodeLengthDiff {

    /**
     * @Author duanding
     * @Description 计算两个选手之间代码（去除注释）长度不同
     * @Date 9:00 PM 2019/9/19
     * @Param [length1, length2]
     * @return double
     **/
    public static double calCodeLengthDiffInPair(int length1, int length2){
        double diffRatio = 0.0;
        double numerator = (double)Math.abs(length1 - length2);
        double denominator = (double) length1;
        if(length1<length2){
            denominator = (double) length2;
        }
        diffRatio = numerator/denominator;
        return diffRatio;
    }
}
