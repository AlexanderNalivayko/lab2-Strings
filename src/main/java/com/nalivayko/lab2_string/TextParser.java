package com.nalivayko.lab2_string;

import java.util.*;

public class TextParser {

    private static final String SENTENCE_SPLIT_REGEX = "[.!?;]";
    private static final String WORD_SPLIT_REGEX = "[\\s,()\"\n]";

    private TextParser() {
    }

    public static int getNumberOfSentencesWithWordRepeat(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int sentencesWithWordRepeats = 0;
        for (String sentence : splitToSentences(text.toLowerCase())) {
            List<String> sentenceWords = new ArrayList<>(Arrays.asList(sentence.split(WORD_SPLIT_REGEX)));

            boolean repeat = new HashSet<>(sentenceWords).stream()
                    .filter(word -> !word.isEmpty())
                    .map(word -> Collections.frequency(sentenceWords, word))
                    .anyMatch(frequency -> frequency > 1);

            sentencesWithWordRepeats += repeat ? 1 : 0;
        }
        return sentencesWithWordRepeats;
    }

    private static String[] splitToSentences(String text) {
        return text.split(SENTENCE_SPLIT_REGEX);
    }
}
