package comp3607project;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;


public class PDFGenerator {

    public static void generatePdf(String filePath, String content) throws IOException {
        // Create a new document
        PDDocument document = new PDDocument();

        try {
            // Add a page to the document
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a new content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set font and font size
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);

            // Set position for the text on the page
            float x = 100;
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