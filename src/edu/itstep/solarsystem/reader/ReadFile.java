package edu.itstep.solarsystem.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public List<String> getLines(String filePath) {

        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath), Charset.forName("utf-8"));
            allLines.remove(0);
            return allLines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
