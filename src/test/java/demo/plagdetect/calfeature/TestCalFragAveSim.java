package demo.plagdetect.calfeature;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import static java.util.Arrays.asList;

public class TestCalFragAveSim {

    @Test
    public void testCalAverageSimlarity(){
        List<Double> tfSimValueList = asList(0.0,100.0,100.0,100.0,100.0,100.0,100.0,100.0,0.0,100.0,0.0,100.0,0.0,0.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,100.0,100.0,0.0,0.0,0.0,100.0,100.0,0.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,100.0,100.0,100.0,0.0,100.0,100.0,100.0,100.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0);
        assertEquals(41.82,CalFragAveSim.calAverageSimlarity(tfSimValueList),0.01);
    }
}
