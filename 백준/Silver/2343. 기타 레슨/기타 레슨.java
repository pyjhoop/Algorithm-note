
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            sum += num;
            arr[i] = num;
        }

        int result = sum;
        while (max <= sum) {
            int mid = (max + sum) / 2;

            int count = 1;
            int currentSum = 0;
            for (int i = 0; i < N; i++) {
                if (currentSum + arr[i] > mid) {
                    count++;
                    currentSum = arr[i];
                } else {
                    currentSum += arr[i];
                }
            }

            if (count <= M) {
                result = mid;
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }

        System.out.println(result);
    }
}