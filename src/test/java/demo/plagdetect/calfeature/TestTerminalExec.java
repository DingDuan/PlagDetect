package demo.plagdetect.calfeature;

import org.junit.Test;

import java.io.File;

public class TestTerminalExec {

    TerminalExec terminalExec = new TerminalExec();

    /**
     * @Author duanding
     * @Description testRunDiff
     * @Date 4:04 PM 2019/9/9
     * @Param []
     * @return void
     **/
    @Test
    public void testRunDiff(){
        File oldFile = new File("/Users/dd/study/iSE/plagiarism_detection/Datalog_clean/1/ValueTest.java");
        File newFile = new File("/Users/dd/study/iSE/plagiarism_detection/Datalog_clean/2/ValueTest.java");
        File compareFile = new File("/Users/dd/study/iSE/out.txt");
        terminalExec.runDiff(oldFile,newFile,compareFile);
    }
}
