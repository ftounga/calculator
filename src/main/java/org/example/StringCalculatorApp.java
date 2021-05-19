package org.example;

import org.example.domain.StringCalculator;
import org.example.exception.BadArgumentException;

/**
 * Hello world!
 *
 */
public class StringCalculatorApp
{
    public static void main( String[] args )
    {

        StringCalculator stringCalculator = new StringCalculator();
        Integer result = null;
        try{
           result  = stringCalculator.add("1,4,5");
        }catch (BadArgumentException e){
            System.out.println(e.getMessage() + ": " + e.getBadArgument());
        }

        System.out.println("Result: " + result);
    }
}
