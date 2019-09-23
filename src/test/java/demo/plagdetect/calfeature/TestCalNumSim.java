package demo.plagdetect.calfeature;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalNumSim {

    @Test
    public void testDetectNum(){
        String s1 = "12.5";
        assertEquals(true,CalNumSim.detectNum(s1));
        String s2 = "-0.423";
        assertEquals(true,CalNumSim.detectNum(s2));
    }
}
