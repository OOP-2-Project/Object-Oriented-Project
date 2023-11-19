package comp3607project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Breakdown implements PrintStrategy {

    @Override
    public void generate(String filePath, String content) throws IOException {
        // Writing content to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }

        // Printing content to the console
        System.out.println("Content:\n" + content);
    }
}

