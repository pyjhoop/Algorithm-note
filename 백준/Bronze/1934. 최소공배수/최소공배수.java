import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x*y/gcd(x,y)
            sb.append((x * y)/ gcd(x,y)).append("\n");
        }

        System.out.println(sb);
    }

    public static int gcd(int x, int y) {
        if(y == 0){
            return x + y;
        }

        return gcd(y, x % y);
    }
}