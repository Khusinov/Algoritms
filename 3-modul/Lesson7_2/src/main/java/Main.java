import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/myExcelFile.xls");
        ) {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/posts (1).txt"));
            Posts[] posts = gson.fromJson(reader, Posts[].class);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow row = sheet.createRow(1);
            row.createCell(0).setCellValue("Id");
            row.createCell(1).setCellValue("User Id");
            row.createCell(2).setCellValue("Title");
            row.createCell(3).setCellValue("Body");

            for (int i = 0; i < posts.length; i++) {
                row = sheet.createRow(i + 2);
                row.createCell(0).setCellValue(posts[i].getId());
                row.createCell(1).setCellValue(posts[i].getUserId());
                row.createCell(2).setCellValue(posts[i].getTitle());
                row.createCell(3).setCellValue(posts[i].getBody());
            }

            // XSSFWorkbook wb = new XSSFWorkbook();
            Sheet sheet1 = workbook.createSheet("My Sample Excel");

            InputStream inputStream = new FileInputStream("src/main/resources/image.jpg");
//Get the contents of an InputStream as a byte[].
            byte[] bytes = IOUtils.toByteArray(inputStream);
//Adds a picture to the workbook
            int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
//close the input stream
            inputStream.close();
//Returns an object that handles instantiating concrete classes
            CreationHelper helper = workbook.getCreationHelper();
//Creates the top-level drawing patriarch.
            Drawing drawing = sheet.createDrawingPatriarch();
//Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(2);
//Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
//Reset the image to the original size
            pict.resize();
//Write the Excel file
            workbook.write(outputStream);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
