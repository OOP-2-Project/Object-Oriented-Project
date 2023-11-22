package comp3607project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Breakdown implements PrintStrategy {

    
    /** 
     * @param filePath
     * @param content
     * @throws IOException
     */
    @Override
    public void generate(String filePath, String content) throws IOException {
        // Check if filePath is null
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
    
        // Writing content to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comp3607project\\src\\main\\java\\comp3607project"))) {
            writer.write(content);
        }
    
        // Printing content to the console
        System.out.println("Content:\n" + content);
    }
}

