
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Map<String, Integer> map = new HashMap<>(){
            {
                for(int i = 0; i < N; i++){
                    String str = br.readLine();
                    put(str, i);
                }
            }
        };

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(map.get(str) != null) count++;
        }

        System.out.println(count);


    }
}