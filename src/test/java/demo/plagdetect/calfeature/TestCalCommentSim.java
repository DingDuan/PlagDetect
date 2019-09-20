package demo.plagdetect.calfeature;

import org.junit.Test;

import java.io.File;

public class TestCalCommentSim {

    @Test
    public void testExtractCommentToFile(){
        File oldFile = new File("/Users/dd/Desktop/DemoRuleTest.java");
        File commentFile = new File("/Users/dd/Desktop/DemoRuleTest_Comment.java");
        CalCommentSim.extractCommentToFile(oldFile,commentFile);
    }
}
