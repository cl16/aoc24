package org.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public static List<String> textFile(String path) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            List<String> data = new ArrayList<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                data.add(line);
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
