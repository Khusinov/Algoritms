import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class Main {
    public static void main(String args[]) throws Exception {
        // Creating a PdfDocument object
        String dest = "C:/itextExamples/addingTable.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument object
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object
     //   Document doc = new Document(pdf);

        // Creating a table
      //  float [] pointColumnWidths = {150F, 150F, 150F};
       // Table table = new Table(pointColumnWidths);

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(new float[]{50, 50})
                .addCell(new Cell().add(new Paragraph("cell 1, 1")))
                .addCell(new Cell().add(new Paragraph("cell 1, 2")));
        doc.add(table);
        doc.close();

        // Adding cells to the table
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Raju"));
        table.addCell(new Cell().add("Id"));
        table.addCell(new Cell().add("1001"));
        table.addCell(new Cell().add("Designation"));
        table.addCell(new Cell().add("Programmer"));

        // Adding Table to document
        doc.add(table);

        // Closing the document
        doc.close();
        System.out.println("Table created successfully..");
    }
}