package demo.plagdetect.util;

import demo.plagdetect.calfeature.CalFileSim;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.io.File;

public class TestFileUtil {

    /**
     * @Author duanding
     * @Description 测试从diff文件中获取不同行数
     * @Date 4:06 PM 2019/9/9
     * @Param []
     * @return void
     **/
    @Test
    public void testCalculateDiffLineFromDiffFile(){
        File diffFile = new File("/Users/dd/study/iSE/out.txt");
        assertEquals(30, FileUtil.calculateDiffLineFromDiffFile(diffFile));
    }

    /**
     * @Author duanding
     * @Description 测试获取文件中代码行数
     * @Date 5:07 PM 2019/9/9
     * @Param []
     * @return void
     **/
    @Test
    public void testCalculateFileLineFromTargetFile(){
        File targetFile1 = new File("/Users/dd/study/iSE/plagiarism_detection/Datalog_clean/1/ValueTest.java");
        assertEquals(24, FileUtil.calculateFileLineFromTargetFile(targetFile1));
        File targetFile2 = new File("/Users/dd/study/iSE/plagiarism_detection/Datalog_clean/2/ValueTest.java");
        assertEquals(22, FileUtil.calculateFileLineFromTargetFile(targetFile2));
    }

    /**
     * @Author duanding
     * @Description 测试获取文件中代码字符数（去除注释）
     * @Date 4:01 PM 2019/9/24
     * @Param []
     * @return void
     **/
    @Test
    public void testCalCodeCharCount(){
        File targetFile = new File("/Users/dd/Desktop/DemoRuleTest.java");
        assertEquals(529,FileUtil.calCodeCharCount(targetFile));
    }
}
