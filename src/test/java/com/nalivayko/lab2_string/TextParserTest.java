package com.nalivayko.lab2_string;

import com.nalivayko.lab2_string.text.Text;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextParserTest {

    private static final String UNIQUE_WORDS_SENTENCE = "some unique words in one sentence.";
    private static final String MULTIPLE_REPEATS_SENTENCE = "dog dog, cat cat, fish fish.";
    private static final String SENTENCES_WITH_REPEAT = "dog dog. cat cat.";
    private static final String REPEATS_DIF_CASE_SENTENCE = "Dog, dog.";

    @Test
    void shouldReturnZeroForNull() {
        int num = TextParser.getNumberOfSentencesWithWordRepeat(null);
        assertThat(num).isEqualTo(0);
    }

    @Test
    void shouldReturnZeroForSentenceWithAllUniqueWords() {
        Text text = TextParser.parseStringToText(UNIQUE_WORDS_SENTENCE);
        int num = TextParser.getNumberOfSentencesWithWordRepeat(text);
        assertThat(num).isEqualTo(0);
    }

    @Test
    void shouldReturnOneForOneSentenceWithMultipleWordRepeats() {
        Text text = TextParser.parseStringToText(MULTIPLE_REPEATS_SENTENCE);
        int num = TextParser.getNumberOfSentencesWithWordRepeat(text);
        assertThat(num).isEqualTo(1);
    }

    @Test
    void shouldReturnTwoForTwoSentencesWithRepeat() {
        Text text = TextParser.parseStringToText(SENTENCES_WITH_REPEAT);
        int num = TextParser.getNumberOfSentencesWithWordRepeat(text);
        assertThat(num).isEqualTo(2);
    }

    @Test
    void shouldReturnOneForSentenceWithRepeatsIgnoringCase() {
        Text text = TextParser.parseStringToText(REPEATS_DIF_CASE_SENTENCE);
        int num = TextParser.getNumberOfSentencesWithWordRepeat(text);
        assertThat(num).isEqualTo(1);
    }

    @Test
    void shouldParseSignsNearWord() {
        String sentence = "word, word.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().get(0).getContent().get(1).getContent()).isEqualTo(",");
    }

    @Test
    void shouldParseSignsNearWordSeparatedByParentheses() {
        String sentence = "(word), word.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().get(0).getContent().get(1).getContent()).isEqualTo(",");
    }

    @Test
    void shouldParseSignsNearWordSeparatedByQuotes() {
        String sentence = "\"word\", word.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().get(0).getContent().get(1).getContent()).isEqualTo(",");
    }

    @Test
    void shouldParseOneWordWithDashInside() {
        String sentence = "some-word.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().get(0).getContent().get(0).getContent()).isEqualTo("some-word");
    }

    @Test
    void shouldParseTwoSentencesSeparatedByDot() {
        String sentence = "sentence. sentence.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().size()).isEqualTo(2);
    }

    @Test
    void shouldParseTwoSentencesSeparatedByExclamation() {
        String sentence = "sentence! sentence.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().size()).isEqualTo(2);
    }

    @Test
    void shouldParseTwoSentencesSeparatedByQuestion() {
        String sentence = "sentence? sentence.";
        Text text = TextParser.parseStringToText(sentence);
        assertThat(text.getSentences().size()).isEqualTo(2);
    }
}