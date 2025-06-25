
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int minVal =Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a < minVal) minVal = a;
            if(a > maxVal) maxVal = a;
        }
        sb.append(minVal).append(" ").append(maxVal);

        System.out.println(sb.toString());
    }
}