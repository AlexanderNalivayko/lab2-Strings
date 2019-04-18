package com.nalivayko.lab2_string;

import com.nalivayko.lab2_string.text.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final String WORD_AND_SIGN_REGEX = "([\\w-]+)([\\s\"\\)]?)([,;.?!]?)";
    private static final String SENTENCE_END_REGEX = "[.;!?]";
    private static final int WORD_GROUP = 1;
    private static final int SIGN_GROUP = 3;

    private TextParser() {
    }

    public static int getNumberOfSentencesWithWordRepeat(Text text) {
        if (text == null || text.getSentences().isEmpty()) {
            return 0;
        }
        int sentencesWithWordRepeats = 0;
        for (Sentence sentence : text.getSentences()) {
            List<SentencePart> sentenceWords = sentence.getContent();
            boolean repeat = new HashSet<>(sentenceWords).stream()
                    .filter(part -> part instanceof Word)
                    .map(word -> Collections.frequency(sentenceWords, word))
                    .anyMatch(frequency -> frequency > 1);
            sentencesWithWordRepeats += repeat ? 1 : 0;
        }
        return sentencesWithWordRepeats;
    }

    public static Text parseStringToText(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String can't be null or empty");
        }
        Pattern pattern = Pattern.compile(WORD_AND_SIGN_REGEX);
        Text text = new Text();
        Matcher matcher = pattern.matcher(str.toLowerCase());
        Sentence sentence = new Sentence();
        while (matcher.find()) {
            sentence.add(new Word(matcher.group(WORD_GROUP)));
            String sign = matcher.group(SIGN_GROUP);
            if (!sign.isEmpty()) {
                sentence.add(new PunctuationSymbol(sign));
                if (sign.matches(SENTENCE_END_REGEX)) {
                    text.addSentence(sentence);
                    sentence = new Sentence();
                }
            }
        }
        return text;
    }
}
