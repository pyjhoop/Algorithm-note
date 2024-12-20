

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[4];

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = min + M;
        int count = 0;
        int[] cnt = new int[4];

        String substr = str.substring(min, max);
        for(int i = 0; i < substr.length(); i++){
            if(substr.charAt(i) == 'A') cnt[0]++;
            else if(substr.charAt(i) == 'C') cnt[1]++;
            else if(substr.charAt(i) == 'G') cnt[2]++;
            else if(substr.charAt(i) == 'T') cnt[3]++;
        }

        while(max <= N) {
            if (arr[0] <= cnt[0] && arr[1] <= cnt[1] && arr[2] <= cnt[2] && arr[3] <= cnt[3]) {
                count++;
            }
            if(max == N) break;
            min++;
            max++;
            char ch = str.charAt(max -1);
            if(ch == 'A') cnt[0]++;
            else if(ch == 'C') cnt[1]++;
            else if(ch == 'G') cnt[2]++;
            else if(ch == 'T') cnt[3]++;

            ch = str.charAt(min - 1);
            if(ch == 'A') cnt[0]--;
            else if(ch == 'C') cnt[1]--;
            else if(ch == 'G') cnt[2]--;
            else if(ch == 'T') cnt[3]--;
        }
        System.out.println(count);
        br.close();
    }
}
