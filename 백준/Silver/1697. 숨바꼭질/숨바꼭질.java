import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;

        while(!queue.isEmpty()){
            int[] val = queue.poll();
            int position = val[0];
            int count = val[1];

            if(position == K) {
                System.out.println(count);
                break;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};

            for(int next : nextPositions) {
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, count + 1});
                }
            }
        }
    }
}
