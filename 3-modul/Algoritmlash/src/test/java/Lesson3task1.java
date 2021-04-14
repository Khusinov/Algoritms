import java.util.Scanner;

public class Lesson3task1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            for (int i = n - 1; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    if (Math.abs(arr[j]) > Math.abs(arr[j + 1]) || (Math.abs(arr[j]) == Math.abs(arr[j + 1]) && arr[j] > arr[i])) {
                        int k = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = k;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

