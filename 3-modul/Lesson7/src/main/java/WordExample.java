import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordExample {
    public static void main(String[] args) {
      XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setItalic(true);
        run.addBreak();
        run.setText("Assalomu Alaykum Dasturchilar!");

        // create table
        XWPFTable table = document.createTable();
        // create first row
        XWPFTableRow tableRow = table.getRow(0);
        tableRow.getCell(0).setText("Birinchi , col1");
        tableRow.addNewTableCell().setText("Ikkinchi");
        tableRow.addNewTableCell().setText("Uchinchi");
        tableRow.addNewTableCell().setText("Do'rtinchi");

        XWPFTableRow tableRow1 = table.createRow();
        tableRow1.getCell(0).setText("Salom");
        tableRow1.getCell(1).setText("Assalom");
        tableRow1.getCell(2).setText("Valaykum");
        tableRow1.getCell(3).setText("Salom");


        try {
            FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/myDocument.docx"));
            document.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
