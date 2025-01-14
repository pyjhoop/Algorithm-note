import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] meters = new int[K];
        long max = 0;

        for(int i=0; i<K; i++) {
            meters[i] = Integer.parseInt(br.readLine());
            if(max < meters[i]) {
                max = meters[i];
            }
        }

        // 로직
        long cnt = 0;
        long min = 1;

        while(min <= max) {
            cnt = 0;
            long mid = (min + max) / 2;
            for(int meter : meters) {
                cnt += meter/mid;
            }

            if(cnt < N) {
                max = mid -1;
            }else {
                min = mid + 1;
            }
        }

        // 출력
        bw.write(String.valueOf(min - 1));

        bw.flush();
        bw.close();
        br.close();

    }

}