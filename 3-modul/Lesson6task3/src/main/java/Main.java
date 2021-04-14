import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Username yoki Email kiriting:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Gson gson = new Gson();
        File file = new File("src/main/resources/users.json");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<ArrayList<Users>>() {
            }.getType();
            ArrayList<Users> arrayList = gson.fromJson(reader, type);

            for (Users users1 : arrayList) {
                //  System.out.println(users1.toString());
                if (users1.getEmail().equals(str) || users1.getUsername().equals(str)) {
                    System.out.println("Company name: " + users1.getCompany().getName() +
                            "\nGeo Lat: " + users1.getAddress().getGeo().getLat() +
                            "\nGeo Lng: " + users1.getAddress().getGeo().getLng());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }

    }
}
