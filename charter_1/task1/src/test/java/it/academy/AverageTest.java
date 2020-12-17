package it.academy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AverageTest {
    @Test
    public void testAverage(){
        List<Integer> testList = new ArrayList<>();
        testList.add(4);
        testList.add(113);
        testList.add(1);
        testList.add(33);
        testList.add(40);
        testList.add(12);
        double expected = 33.8333333333;
        assertEquals(expected, Average.CountAverage(testList), 1e-6);

    }

}