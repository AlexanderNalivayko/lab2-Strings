package com.nalivayko.lab2_string;

public class Runner {

    public static void main(String[] args) {

        int count = TextParser.getNumberOfSentencesWithWordRepeat(TextReader.readFromFile("text.txt"));
        System.out.printf("There are %d sentences with words repeat.", count);

    }
}
