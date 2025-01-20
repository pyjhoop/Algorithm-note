import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.merge(temp, 1, Integer::sum);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i =0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(map.get(temp) == null) {
                sb.append(0).append(" ");
            }else {
                sb.append(map.get(temp)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
