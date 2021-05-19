package org.example.domain;

import org.apache.commons.lang3.StringUtils;
import org.example.enumeration.BusinessErrorCode;
import org.example.exception.BadArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    public StringCalculator(){}

    public Integer add(String numbers) {
        String delimiter = StringUtils.substringBetween(numbers, "//", "\n");
        List<Integer> numbersTab = null;
        if (StringUtils.isBlank(delimiter)){
            numbersTab = defaultSplit(numbers);
        }else {
            numbersTab = splitByProvidedDelimiter(numbers, delimiter);
        }
        validate(numbersTab);
        return numbersTab.stream().map(n -> Integer.valueOf(n)).reduce(0, Integer::sum);
    }

    private List<Integer> defaultSplit(String numbers){
        return Arrays.asList(numbers.split(",|\\\n")).stream()
                .filter(n -> !n.isBlank())
                .map(n -> Integer.valueOf(n))
                .filter(n -> n <= 1000)
                .collect(Collectors.toList());
    }

    private List<Integer> splitByProvidedDelimiter(String numbers, String delimiters){
        return Arrays.asList(StringUtils.substringAfter(numbers,"\n").split(delimiters))
                .stream()
                .filter(n -> !n.isBlank())
                .map(n -> Integer.valueOf(n))
                .filter(n -> n <= 1000)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> input) {
        String negativeValues = input.stream().filter(n -> n < 0).map(integer -> String.valueOf(integer)).collect(Collectors.joining(", "));
        if (!negativeValues.isEmpty()){
            BadArgumentException badArgumentException = new BadArgumentException(BusinessErrorCode.NEGATIVE_INPUT_NOT_ALLOWED, negativeValues);
            throw badArgumentException;
        }
    }
}
