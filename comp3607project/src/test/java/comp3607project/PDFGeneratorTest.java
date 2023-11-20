package comp3607project;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class PDFGeneratorTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    
    /** 
     * @throws IOException
     */
    @Test
    public void testGeneratePdf() throws IOException {
        
        PDFGenerator pdfGenerator = new PDFGenerator();
        
        File pdfFile = testFolder.newFile("test.pdf");

        String content = "Hello World";

        pdfGenerator.generate(pdfFile.getAbsolutePath(), content);

        assertTrue(pdfFile.exists());
        assertTrue(pdfFile.length() > 0); 
    }
}
