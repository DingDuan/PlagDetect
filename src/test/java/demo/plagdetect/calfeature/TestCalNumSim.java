package demo.plagdetect.calfeature;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCalNumSim {

    /**
     * @Author duanding
     * @Description 测试从文件提取数值常量
     * @Date 5:30 PM 2019/9/24
     * @Param []
     * @return void
     **/
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

    /**
     * @Author duanding
     * @Description 测试根据两个选手数值常量列表计算相似度
     * @Date 5:31 PM 2019/9/24
     * @Param []
     * @return void
     **/
    @Test
    public void testCalNumSim(){
        List<String> numList1 = new ArrayList();
        numList1.add("8");
        numList1.add("8");
        numList1.add("-5.3");
        numList1.add("12");
        numList1.add("3.54");
        numList1.add("-0.54");
        numList1.add("0.54");
        numList1.add("22.54");
        List<String> numList2 = new ArrayList<>();
        numList2.add("8");
        numList2.add("8");
        numList2.add("8");
        numList2.add("-0.54");
        numList2.add("-21");
        assertEquals(0.375,CalNumSim.calNumSim(numList1,numList2),0.001);
    }
}
