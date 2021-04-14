import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        File file = new File("src/main/resources/comments.json");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<ArrayList<Comment>>() {
            }.getType();
            ArrayList<Comment> userArray = gson.fromJson(bufferedReader, type);
            int id = 0, postId = 0, maxLength = 0, minLength = 10000000;
            String longComment = null, shortComment = null, longCommentEmail = null, shortCommentEmail = null;
            List<String> MoreCommentEmail = new ArrayList<String>();
            for (Comment comment : userArray) {
                if (id < comment.getId()) {
                    id = comment.getId();
                }
                if (postId < comment.getPostId()) {
                    postId = comment.getPostId();
                }
                System.out.println(comment.getEmail());
                if (maxLength < comment.getBody().length()) {
                    maxLength = comment.getBody().length();
                    longComment = comment.getBody();
                    longCommentEmail = comment.getEmail();
                }
                if (minLength > comment.getBody().length()) {
                    minLength = comment.getBody().length();
                    shortComment = comment.getBody();
                    shortCommentEmail = comment.getEmail();
                }
                // bir martadan ko'p comment yozgan emailni topish
                String searchEmail = comment.getEmail();
                int snt = 0;

                for (Comment comment1 : userArray) {
                    if (comment1.getEmail().equals(searchEmail)) {
                        snt++;
                    }
                }
                if (snt > 1) {
                    MoreCommentEmail.add(searchEmail);
                }

            }
            System.out.println("Commentlar soni: " + id);
            System.out.println("Postlar soni:" + postId);
            System.out.println("Long comment |\n " + longComment);
            System.out.println("Long comment egasi :" + longCommentEmail);
            System.out.println("Short Comment | \n" + shortComment);
            System.out.println("Short comment egasi :" + shortCommentEmail);
            System.out.println("Bir martadan ko'p comment yozgan emaillar:");

            if (MoreCommentEmail.isEmpty()) {
                System.out.println("Bunday Email topilmadi!");
            } else {
                for (String S : MoreCommentEmail) {
                    System.out.println(S);
                } }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
