package demo.plagdetect.calfeature;

import org.junit.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestCalFileSim {

    CalFileSim calFileSim = new CalFileSim();

    /**
     * @Author duanding
     * @Description 测试计算相似度
     * @Date 5:01 PM 2019/9/11
     * @Param []
     * @return void
     **/
    @Test
    public void testCalculateSimValueByDiff(){
        assertEquals(0.0,CalFileSim.calculateSimValueByDiff(24,22,30),0.001);
    }

    /**
     * @Author duanding
     * @Description 测试由diff文件名获得cid1和cid2文件名
     * @Date 5:02 PM 2019/9/11
     * @Param []
     * @return void
     **/
    @Test
    public void testGetFileName(){
        int pointIndex = 0;
        File diffFile = new File("/Users/dd/study/iSE/Graduation-Design/ExperimentResult/1.ValueTest vs 2.VariableTest.txt ");
        String diffFileName = diffFile.getName();
        if ("diff_result.csv".equals(diffFileName)) {
            diffFile.delete();
        }
        String[] file1_fil2_array = diffFileName.split(" vs ");
        String cid1FileName = file1_fil2_array[0].trim();
        pointIndex = cid1FileName.indexOf(".");
        cid1FileName = cid1FileName.substring(pointIndex + 1);
        assertEquals("ValueTest",cid1FileName);

        String cid2FileName = file1_fil2_array[1].trim();
        pointIndex = cid2FileName.indexOf(".");
        cid2FileName = cid2FileName.substring(pointIndex + 1);
        pointIndex = cid2FileName.indexOf(".");
        cid2FileName = cid2FileName.substring(0, pointIndex);
        assertEquals("VariableTest",cid2FileName);
    }

}
