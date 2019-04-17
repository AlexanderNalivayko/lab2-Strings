package com.nalivayko.lab2_string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextReaderTest {

    @Test
    public void shouldThrowExceptionOnNull() {
        assertThrows(IllegalArgumentException.class, () -> TextReader.readFromFile(null));
    }

    @Test
    public void shouldThrowExceptionOnEmpty() {
        assertThrows(IllegalArgumentException.class, () -> TextReader.readFromFile(""));
    }
}