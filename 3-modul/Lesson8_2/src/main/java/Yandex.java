import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Yandex {
    public static void main(String[] args) {
       String  word ;
       Scanner scanner = new Scanner(System.in);
       word = scanner.nextLine();

        try {
            URL url = new URL("https://yandex.uz/search/?text=" + word);
            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String lines ;
            while ((lines = reader.readLine()) != null){
                System.out.println(lines);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
