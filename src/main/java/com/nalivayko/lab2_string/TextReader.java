package com.nalivayko.lab2_string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

    private TextReader() {
    }

    public static String readFromFile(String path){
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException(String.format("Can't perform such path: \"%s\"", path));
        }
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
