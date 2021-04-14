import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Album;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("src/main/resources/Album.json");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Album album1 = gson.fromJson(reader ,Album.class);
            String albumString = gson.toJson(album1);
            System.out.println(album1.getUserName() + " it is username");
            System.out.println(album1);
            System.out.println(albumString);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
