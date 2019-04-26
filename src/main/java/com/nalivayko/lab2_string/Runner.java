package com.nalivayko.lab2_string;

import com.nalivayko.lab2_string.text.Text;

import static com.nalivayko.lab2_string.TextParser.getNumberOfSentencesWithWordRepeat;
import static com.nalivayko.lab2_string.TextParser.parseStringToText;

public class Runner {
    private static final String FILE_PATH = "text.txt";
    private static final String FORMAT = "there are %d sentences with words repeat";

    public static void main(String[] args) {
        Text text = parseStringToText(TextReader.readFromFile(FILE_PATH));
        System.out.printf(FORMAT, getNumberOfSentencesWithWordRepeat(text));
    }
}
