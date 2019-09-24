package demo.plagdetect.calfeature;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import static java.util.Arrays.asList;

public class TestCalFragAveSim {

    /**
     * @Author duanding
     * @Description 测试计算片段相似度平均值
     * @Date 3:38 PM 2019/9/24
     * @Param []
     * @return void
     **/
    @Test
    public void testCalAverageSimlarity(){
        List<Double> tfSimValueList = asList(0.0,100.0,100.0,100.0,100.0,100.0,100.0,100.0,0.0,100.0,0.0,100.0,0.0,0.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,100.0,100.0,0.0,0.0,0.0,100.0,100.0,0.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,100.0,100.0,100.0,0.0,100.0,100.0,100.0,100.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0);
        assertEquals(41.82,CalFragAveSim.calAverageSimlarity(tfSimValueList),0.01);
    }
}
