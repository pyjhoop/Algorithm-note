
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i =1; i <= N; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for (List<Integer> neighbors : map.values()) {
            Collections.sort(neighbors);
        }

        dfs(sb, start, map, set);
        set.clear();
        bfs(sb2, start, map, queue, set);
        System.out.println(sb);
        System.out.println(sb2);
    }

    static void dfs(StringBuilder sb, int start, Map<Integer, List<Integer>> map, Set<Integer> set) {
        sb.append(start).append(" ");
        set.add(start);
        List<Integer> list = map.get(start);

        for(int i = 0; i < list.size(); i++) {
            if(!set.contains(list.get(i))) {
                dfs(sb, list.get(i), map, set);
            }
        }
    }

    static void bfs(StringBuilder sb2, int start, Map<Integer, List<Integer>> map, Deque<Integer> queue, Set<Integer> set){
        queue.addLast(start);
        set.add(start);

        while(!queue.isEmpty()) {
            int nodeIndex = queue.pollFirst();
            sb2.append(nodeIndex).append(" ");
            List<Integer> list = map.get(nodeIndex);
            for(Integer num : list){
                if(!set.contains(num)){
                    set.add(num);
                    queue.addLast(num);
                }
            }
        }
    }
}
