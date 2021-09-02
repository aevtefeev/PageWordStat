package ru.crmkrd.pws;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeparatorsStringTest {

    @Test
    public void getSeparators() {
        String expected = " |\\,|\\.|\\!|\\?|\\(|\\)|\\[|\\]|\\-|\\;|\\:|\\\n|\\\r|\\\t";
        SeparatorsString separators = new SeparatorsString();
        String sSeparators = separators.getSeparators();
        Assert.assertEquals(expected, sSeparators);
    }
}