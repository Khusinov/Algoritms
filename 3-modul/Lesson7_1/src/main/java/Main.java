import com.google.gson.Gson;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.lang.management.GarbageCollectorMXBean;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String source = "src/main/resources/comments.json";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            Comments[] comments = gson.fromJson(bufferedReader, Comments[].class);
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setBold(true);
            run.setText("SHAXRIYOR XUSINOV");

            XWPFTable table = document.createTable();

            XWPFTableRow tableRow = table.getRow(0);
            tableRow.getCell(0).setText("postId");
            tableRow.addNewTableCell().setText("id");
            tableRow.addNewTableCell().setText("name");
            tableRow.addNewTableCell().setText("email");
            tableRow.addNewTableCell().setText("body");

            for (Comments comment : comments) {
                tableRow = table.createRow();
                tableRow.getCell(0).setText(comment.getPostId().toString());
                tableRow.getCell(1).setText(comment.getId().toString());
                tableRow.getCell(2).setText(comment.getName());
                tableRow.getCell(3).setText(comment.getEmail());
                tableRow.getCell(4).setText(comment.getBody());
            }

            tableRow = table.createRow();


            FileOutputStream out = new FileOutputStream("MyDocWord.docx");
            document.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
