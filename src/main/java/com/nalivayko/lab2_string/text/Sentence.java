package com.nalivayko.lab2_string.text;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private final List<SentencePart> content = new ArrayList<>();

    public Sentence() {
    }

    public void add(SentencePart sentencePart) {
        content.add(sentencePart);
    }

    public List<SentencePart> getContent() {
        return content;
    }
}
