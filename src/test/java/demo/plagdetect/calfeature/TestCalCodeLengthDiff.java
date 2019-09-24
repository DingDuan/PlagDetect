package demo.plagdetect.calfeature;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalCodeLengthDiff {

    /**
     * @Author duanding
     * @Description 测试计算一对选手之间代码长度不同
     * @Date 3:59 PM 2019/9/24
     * @Param []
     * @return void
     **/
    @Test
    public void testCalCodeLengthDiffInPair(){
        assertEquals(0.574, CalCodeLengthDiff.calCodeLengthDiffInPair(181,425),0.001);
    }
}
