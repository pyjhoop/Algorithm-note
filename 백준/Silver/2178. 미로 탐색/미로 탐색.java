
import java.io.*;
import java.util.*;

public class Main {
    /*
    좌표니 dx, dy 배열을 만든다.
    2차원 배열의 크기를 구한다.
    조건문을 통해 상하좌우 간 인접 배열이 되고 해당 인접 배열을 탐색하면 된다.
    2차원 배열이기에 visited 도 이차원 배열로 만들면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        // 2차원 배열 세팅
        for(int i = 0; i < N; i++){
            String[] strArr = br.readLine().split("");

            for(int j = 0; j < strArr.length; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1}); // 시작점 (0, 0) 거리 1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] valArr = queue.poll();
            int x = valArr[0];
            int y = valArr[1];
            int distance = valArr[2];

            // 도착 지점에 도달한 경우
            if (x == N - 1 && y == M - 1) {
                System.out.println(distance);
                return;
            }

            // 상하좌우 탐색
            for (int j = 0; j < 4; j++) {
                int tempX = x + dx[j];
                int tempY = y + dy[j];

                if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M && !visited[tempX][tempY] && arr[tempX][tempY] == 1) {
                    visited[tempX][tempY] = true;
                    queue.add(new int[] {tempX, tempY, distance + 1});
                }
            }
        }
    }
}
