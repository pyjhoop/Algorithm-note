import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, V, E;
    static ArrayList<Integer>[] adj;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            colors = new int[V + 1]; // 0: 방문 X, 1: 빨강, -1: 파랑

            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colors[start] = 1; // 시작 정점은 빨강으로 칠한다.

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj[u]) {
                if (colors[v] == 0) {
                    colors[v] = -colors[u]; // 현재 정점과 반대 색으로 칠한다.
                    q.offer(v);
                } else if (colors[v] == colors[u]) {
                    // 인접한 정점인데 같은 색이면 이분 그래프가 아니다.
                    return false;
                }
            }
        }
        return true;
    }
}