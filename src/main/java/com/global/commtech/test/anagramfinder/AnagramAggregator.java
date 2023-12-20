package com.global.commtech.test.anagramfinder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramAggregator {

    public static Map<String, List<String>> aggregateAnagrams(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(AnagramAggregator::sortedAlphabetically));
    }

    private static String sortedAlphabetically(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
