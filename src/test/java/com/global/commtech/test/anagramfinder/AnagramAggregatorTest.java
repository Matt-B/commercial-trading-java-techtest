package com.global.commtech.test.anagramfinder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AnagramAggregatorTest {

    AnagramAggregator anagramAggregator;

    @BeforeEach
    public void setup() {
        anagramAggregator = new AnagramAggregator();
    }

    @Test
    void shouldReturnZeroGroupsWhenPassedEmptyList() {
        assertThat(anagramAggregator.aggregateAnagrams(List.of()).size()).isEqualTo(0);
    }

    @Test
    void shouldAggregateSingleLetterAnagramsIntoASingleGroup() {
        assertThat(anagramAggregator.aggregateAnagrams(Arrays.asList(
                "a",
                "a"
        )).size()).isEqualTo(1);
    }

    @Test
    void shouldAggregateAnagramsIntoASingleGroup() {
        assertThat(anagramAggregator.aggregateAnagrams(Arrays.asList(
                "aba",
                "baa"
        )).size()).isEqualTo(1);
    }

    @Test
    void shouldAggregateAnagramsIntoTwoGroups() {
        assertThat(anagramAggregator.aggregateAnagrams(Arrays.asList(
                "baab",
                "baba",
                "aaab",
                "baaa"
        )).size()).isEqualTo(2);
    }

    @Test
    void shouldAggregateAnagramsOfDifferentLengths() {
        assertThat(anagramAggregator.aggregateAnagrams(Arrays.asList(
                "a",
                "a",
                "racecar",
                "carrace",
                "snoooooooooooooop",
                "soooooooooooooonp"
        )).size()).isEqualTo(3);
    }
}
