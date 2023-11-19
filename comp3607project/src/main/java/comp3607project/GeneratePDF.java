package comp3607project;

import java.io.IOException;

public class GeneratePDF {
    
    private PDFGenerator pdfGenerator;

    public GeneratePDF(String filePath, String content) throws IOException{
        pdfGenerator.generate(filePath, content);;
    }
    
}
