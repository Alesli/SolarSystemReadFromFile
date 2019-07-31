package edu.itstep.solarsystem.writer;

import edu.itstep.solarsystem.config.FileConfig;
import edu.itstep.solarsystem.model.impl.Sun;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {

    // состояние объекта Sun записывается к строке и отправляется в метод writeLines
    public void writeFile(List<Sun> suns){
        List<String> list = new ArrayList<>();
        for (Sun sun : suns) {
            list.add(sun.toString());
        }
        writeLines(list);
    }
//    String filePath = "D:/";
//    String fileName = "file.txt";
//    File file = new File(filePath + fileName);

    public void writeLines(List<String> lines) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(FileConfig.OUTPUT_FILE))){
            for (String line : lines) {
                bf.write(line);
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
