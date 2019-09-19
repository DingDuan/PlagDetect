package demo.plagdetect.calfeature;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalCodeLengthDiff {

    @Test
    public void testCalCodeLengthDiffInPair(){
        assertEquals(0.574, CalCodeLengthDiff.calCodeLengthDiffInPair(181,425),0.001);
    }
}
