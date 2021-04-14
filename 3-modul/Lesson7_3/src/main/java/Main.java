import com.google.gson.Gson;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.Document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/photos.json"))) {
            Photos[] photos = gson.fromJson(reader, Photos[].class);

            String file = "src/main/resources/myPdf.pdf";
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(file));
            pdfDoc.addNewPage();
            //Creating a Document object
            Document doc = new Document(pdfDoc);

            Paragraph paragraph1 = new Paragraph("Paragraf1");
            doc.add(paragraph1);

            float [] pointColumnWidths = {50F, 50F, 150F , 150F , 150F};
            Table table = new Table(pointColumnWidths);

            table.addCell("id");
            table.addCell("album id");
            table.addCell("title");
            table.addCell("url");
            table.addCell("thumbnailUrl");

            for (Photos photo : photos) {
                table.addCell(photo.getId().toString());
                table.addCell(photo.getAlbumId().toString());
                table.addCell(photo.getTitle().toString());
                table.addCell(photo.getUrl().toString());
                table.addCell(photo.getThumbnailUrl().toString()); 
            }

            doc.add(table);

            //Closing the document
            doc.close();
            System.out.println("Table created successfully..");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
