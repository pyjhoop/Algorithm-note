

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[arr.length - 1];
        long max = 0;

        while(start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for(int num : arr) {
                count += num / mid;
            }

            if(count >= N) {
                max = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        System.out.println(max);
    }
}
