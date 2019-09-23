package demo.plagdetect.calfeature;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCalNumSim {

    @Test
    public void testExtractNumFromFile(){
        File file = new File("/Users/dd/Desktop/TryData/ALUTest1.java");
        List<String> expectList = new ArrayList<>();
        expectList.add("8");
        expectList.add("8");
        expectList.add("8");
        expectList.add("4");
        expectList.add("8");
        expectList.add("8");
        expectList.add("12");
        expectList.add("8");
        expectList.add("1200");
        assertEquals(expectList,CalNumSim.extractNumFromFile(file));
    }

    /**
     * @Author duanding
     * @Description 测试检测数值
     * @Date 7:34 PM 2019/9/23
     * @Param []
     * @return void
     **/
    @Test
    public void testDetectNum(){
        String s1 = "12.5";
        assertEquals(true,CalNumSim.detectNum(s1));
        String s2 = "-0.423";
        assertEquals(true,CalNumSim.detectNum(s2));
    }
}
