import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        // 점 배열 정렬
        Arrays.sort(points);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            // 시작점 이상의 첫 번째 위치
            int leftIdx = lowerBound(points, left);

            // 끝점 이하의 마지막 위치
            int rightIdx = upperBound(points, right);

            // 범위 내 점의 개수 계산
            sb.append(rightIdx - leftIdx + 1).append("\n");
        }

        System.out.print(sb);
    }

    // lowerBound: 시작점 이상이 처음으로 등장하는 위치
    public static int lowerBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int result = arr.length; // 기본값: 찾지 못하면 arr.length 반환
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    // upperBound: 끝점 이하가 마지막으로 등장하는 위치
    public static int upperBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int result = -1; // 기본값: 찾지 못하면 -1 반환
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}