package com.global.commtech.test.anagramfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramFileParser {

    public static void parseAnagramFile(File file) throws AnagramFileParserException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int currentLineLength = 0;
            List<String> words = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if(line.length() == currentLineLength) {
                    words.add(line);
                } else {
                    if (!words.isEmpty()) {
                        printAnagrams(AnagramAggregator.aggregateAnagrams(words));
                    }
                    words = new ArrayList<>();
                    words.add(line);
                    currentLineLength = line.length();
                }
            }
            if (!words.isEmpty()) {
                printAnagrams(AnagramAggregator.aggregateAnagrams(words));
            }
        } catch (Exception e) {
            throw new AnagramFileParserException(e.getMessage());
        }
    }

    private static void printAnagrams(Map<String, List<String>> anagrams) {
        for (List<String> value : anagrams.values()) {
            System.out.println(value.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
    }
}
