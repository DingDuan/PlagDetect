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
        File targetFile = new File("/Users/dd/study/iSE/plagiarism_detection/Datalog_clean/2/ValueTest.java");
        assertEquals(22, FileUtil.calculateFileLineFromTargetFile(targetFile));
    }
}
