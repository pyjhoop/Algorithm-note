import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]){
                    result.add(dfs(i, j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int size : result) {
            System.out.println(size);
        }
    }

    static int dfs(int row, int column) {
        visited[row][column] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 1;

        for(int i =0; i< 4; i++){
            int nx = row + dx[i];
            int ny = column + dy[i];

            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
}
