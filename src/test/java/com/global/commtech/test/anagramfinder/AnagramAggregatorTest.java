package com.global.commtech.test.anagramfinder;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AnagramAggregatorTest {

    @Test
    void shouldReturnZeroGroupsWhenPassedEmptyList() {
        assertThat(AnagramAggregator.aggregateAnagrams(List.of()).size()).isEqualTo(0);
    }

    @Test
    void shouldAggregateSingleLetterAnagramsIntoASingleGroup() {
        assertThat(AnagramAggregator.aggregateAnagrams(Arrays.asList(
                "a",
                "a"
        )).size()).isEqualTo(1);
    }

    @Test
    void shouldAggregateAnagramsIntoASingleGroup() {
        assertThat(AnagramAggregator.aggregateAnagrams(Arrays.asList(
                "aba",
                "baa"
        )).size()).isEqualTo(1);
    }

    @Test
    void shouldAggregateAnagramsIntoTwoGroups() {
        assertThat(AnagramAggregator.aggregateAnagrams(Arrays.asList(
                "baab",
                "baba",
                "aaab",
                "baaa"
        )).size()).isEqualTo(2);
    }

    @Test
    void shouldAggregateAnagramsOfDifferentLengths() {
        assertThat(AnagramAggregator.aggregateAnagrams(Arrays.asList(
                "a",
                "a",
                "racecar",
                "carrace",
                "snoooooooooooooop",
                "soooooooooooooonp"
        )).size()).isEqualTo(3);
    }
}
