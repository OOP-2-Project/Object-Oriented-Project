package comp3607project;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

/** 
 * Uses the PrintStrategy strategy interface and overides the method to print to a PDF
 */
public class PDFGenerator implements PrintStrategy{

    
    /** 
     * @param filePath The file path of the PDF file that will store the results
     * @param content A string variable holding all the text to be saved
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    public void generate(String filePath, String content) throws IOException {
        // Create a new document
        PDDocument document = new PDDocument();

        try {
            // Add a page to the document
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a new content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
                        // Specify a different font if needed
            // Specify a different font if needed

            // Set font and font size
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);

            // Set position for the text on the page
            float x = 20;
            float y = page.getMediaBox().getHeight() - 100;

            // Add text to the page
            contentStream.beginText();
            contentStream.newLineAtOffset(x, y);
            contentStream.showText(content);
            contentStream.endText();

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            document.save(filePath);
        } finally {
            // Close the document
            document.close();
        }
    }
}