import com.itextpdf.layout.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>(10);
        // 10 ta user : inn null ga teng | for orqali inn set qilinadi
        //
        list.add(new User("Shaxriyor", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000001, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Abdulla", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000002, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Asad", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000003, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("MuhammadAmin", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000004, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Muhammad", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000005, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Ulugbek", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000006, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Asadulloh", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000007, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Yusufbek", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000008, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("MuhammadAli", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000009, null, true,
                "19.10.2001", "Oliy", false));
        list.add(new User("Abror", "Xusinov", "Yorqinbek o'gli",
                "Hazorasp", 1000010, null, true,
                "19.10.2001", "Oliy", false));

        // listning inn sini generatsiya orqali set qilish


        Random random = new Random();
       int i ;
       i = 0 ;
        User user = new User();
        // 10 ta 9 xonali sonni setInn() qilish
        random.ints(10, 100000000, 999999999).forEachOrdered(
                value -> {
                    list.set( i  , user.setInn(value));
                }
        );

     File file = new File("res/main/resources/mySoloq.pdf");
        Document document = new Document(file);





    }
}
