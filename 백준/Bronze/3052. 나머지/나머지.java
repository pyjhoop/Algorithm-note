import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[42];

        int temp = 0;
        for(int i = 0; i < 10; i++) {
            temp = Integer.parseInt(br.readLine());

            temp = temp % 42;
            arr[temp]++;
        }

        int sum = 0;
        for(int i : arr) {
            if(i > 0) sum++;
        }

        System.out.println(sum);
        br.close();
    }
}