
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

      

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;

        long closestSum = Long.MAX_VALUE; // 0에 가장 가까운 합
        long[] result = new long[2];

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < closestSum) {
                closestSum = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (sum < 0) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

}
