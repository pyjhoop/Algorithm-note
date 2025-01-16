
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) {
                max = tree[i];
            }
        }
        int start = 0;
        int end = max;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;

            for (int height : tree) {
                if (height > mid) {
                    total += height - mid;
                }
            }

            if (total >= M) {
                result = mid; // 최대 절단기 높이 저장
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
