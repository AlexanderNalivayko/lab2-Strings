package com.nalivayko.lab2_string.text;

public abstract class SentencePart {

    private final String content;

    public SentencePart(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentencePart that = (SentencePart) o;

        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
