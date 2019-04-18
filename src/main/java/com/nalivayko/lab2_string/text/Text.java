package com.nalivayko.lab2_string.text;

import java.util.LinkedList;
import java.util.List;

public class Text {

    private static final String FORMAT = "<%s> ";

    private final List<Sentence> sentences = new LinkedList<>();

    public Text() {
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence sentence : sentences) {
            for (SentencePart sentencePart : sentence.getContent()) {
                stringBuilder.append(String.format(FORMAT, sentencePart.getContent()));
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
