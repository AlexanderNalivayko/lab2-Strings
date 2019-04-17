package com.nalivayko.lab2_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextParserTest {

    private static final String UNIQUE_WORDS_SENTENCE = "some unique words in one sentence.";
    private static final String MULTIPLE_REPEATS_SENTENCE = "dog dog, cat cat, fish fish.";
    private static final String SENTENCES_WITH_REPEAT = "dog dog. cat cat.";
    private static final String REPEATS_DIF_CASE_SENTENCE = "Dog, dog.";

    @Test
    public void shouldReturnZeroForNull() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat(null);
        assertThat(num).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroForEmpty() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat("");
        assertThat(num).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroForSentenceWithAllUniqueWords() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat(UNIQUE_WORDS_SENTENCE);
        assertThat(num).isEqualTo(0);
    }

    @Test
    public void shouldReturnOneForOneSentenceWithMultipleWordRepeats() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat(MULTIPLE_REPEATS_SENTENCE);
        assertThat(num).isEqualTo(1);
    }

    @Test
    public void shouldReturnTwoForTwoSentencesWithRepeat() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat(SENTENCES_WITH_REPEAT);
        assertThat(num).isEqualTo(2);
    }

    @Test
    public void shouldReturnOneForSentenceWithRepeatsIgnoringCase() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat(REPEATS_DIF_CASE_SENTENCE);
        assertThat(num).isEqualTo(1);
    }
}