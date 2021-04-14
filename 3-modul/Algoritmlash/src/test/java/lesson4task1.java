import java.util.Scanner;

public class lesson4task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        int s = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i] > arr[j]) {
                    s++;
                }
            }
        }
        System.out.println(s);
    }
}

