package comp3607project;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try {
            PDFGenerator.generatePdf("example.pdf", "HELLO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
