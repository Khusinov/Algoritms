import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Id ni kiriting: ");
        int userId = sc.nextInt();
        Gson gson = new Gson();
        File file = new File("src/main/resources/todos.json");
        ArrayList<String> arrayList = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<ArrayList<Todos>>() {
            }.getType();
            ArrayList<Todos> userArray = gson.fromJson(reader, type);
            System.out.println("\nTugallangan Amallari:");
            for (Todos todos : userArray) {
                if (todos.getUserId() == userId && todos.isCompleted()) {
                    System.out.println(todos.getTitle());
                }
            }
            System.out.println("\n\nTugallanmagan Amallari:");
            for (Todos todos1 : userArray) {
                if (todos1.getUserId() == userId && !todos1.isCompleted()) {
                    System.out.println(todos1.getTitle());
                }
            }
            // yangi todo qo'shish
            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Yangi todo qo'shing:");
            String str1 = scanner4.nextLine();
            Todos todos = new Todos(201, 201, str1, false);
            userArray.add(todos);
            // todo ni edit qilish
            System.out.print("Qaysi todo ni edit qilmoqchisiz? \nId = ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            System.out.println(userArray.get(id - 1).getTitle());
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Yangi satrni kiriting:");
            String str = scanner1.nextLine();
            Todos todos3 = new Todos(id, id, str, false);
            userArray.set(id-1, todos3);
            //todos.setTitle(str);
            System.out.println();
            //todo ni o'chirish
            System.out.println("Qaysi todo ni o'chirmoqchisan? \nId = ");
            Scanner scanner2 = new Scanner(System.in);
            int index = scanner2.nextInt();
            userArray.remove(index - 1);
            System.out.println("Element muvaffaqqiyatli o'chirildi!");
// todo qidirish
            System.out.println("Todo qidirish : ");
            Scanner scanner3 = new Scanner(System.in);
            String searchT = scanner3.nextLine();
            for (Todos searchTitle : userArray) {
                if (searchT.contains(searchTitle.getTitle())){
                    System.out.println("Siz qidirayotgan title " + searchTitle.getId());
                }
            }


            for (Todos todos1 : userArray) {
                System.out.println(todos1.getId() + " " + todos1.getTitle());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}