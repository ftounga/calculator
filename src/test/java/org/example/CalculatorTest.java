package org.example;

import static org.junit.Assert.assertTrue;

import org.example.domain.StringCalculator;
import org.example.exception.BadArgumentException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnResult() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1,4,5";
        Integer result = stringCalculator.add(input);
        assertTrue( result.equals(10) );
    }

    @Test
    public void shouldReturnZero() {
        StringCalculator stringCalculator = new StringCalculator();
        Integer result = stringCalculator.add("");
        assertTrue( result.equals(0) );
    }

    @Test
    public void shouldReturnResultWithNewLineDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1\n2,3";
        Integer result = stringCalculator.add(input);
        assertTrue( result.equals(6) );
    }

    @Test
    public void shouldReturnResultWithProvidedDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "//;\n1;2";
        Integer result = stringCalculator.add(input);
        assertTrue( result.equals(3) );
    }

    @Test(expected = BadArgumentException.class)
    public void shouldThrowExceptionWhenNegativeInput()
    {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1,4,-5";
        Integer result = stringCalculator.add(input);
    }

    @Test
    public void shouldIgnoreNumberGreatherThan1000() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1,4,5,1001";
        Integer result = stringCalculator.add(input);
        assertTrue( result.equals(10) );
    }

    @Test
    public void shouldReturnResultWithLongProvidedDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "//[***]\n1***2***3";
        Integer result = stringCalculator.add(input);
        assertTrue( result.equals(6) );
    }

    @Test
    public void shouldReturnResultWithMultipleProvidedDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "//[***][%%%]\n1***2***3%%%1";
        Integer result = stringCalculator.add(input);
        assertTrue( result.equals(7) );
    }
}
