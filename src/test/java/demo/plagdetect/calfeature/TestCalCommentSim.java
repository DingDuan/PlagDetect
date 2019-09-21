package demo.plagdetect.calfeature;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestCalCommentSim {

    /**
     * @Author duanding
     * @Description 测试提取注释并存到文件
     * @Date 11:00 AM 2019/9/21
     * @Param []
     * @return void
     **/
    @Test
    public void testExtractCommentToFile(){
        File oldFile = new File("/Users/dd/Desktop/DemoRuleTest.java");
        File commentFile = new File("/Users/dd/Desktop/DemoRuleTest_Comment.java");
        CalCommentSim.extractCommentToFile(oldFile,commentFile);
    }

    @Test
    public void testCalLineSimByDiff(){
        File commentFile1 = new File("/Users/dd/Desktop/DemoRuleTest_Comment.java");
        File commentFile2 = new File("/Users/dd/Desktop/DemoRuleTest_Comment 2.java");
        File compareFile = new File("/Users/dd/Desktop/CommentDiff.txt");
        assertEquals(1.0,CalCommentSim.calLineSimByDiff(commentFile1,commentFile2,compareFile),0.1);
    }
}
