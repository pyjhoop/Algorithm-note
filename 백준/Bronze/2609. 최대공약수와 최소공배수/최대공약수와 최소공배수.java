import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(gcd(x, y));
        System.out.println(lcm(x, y));
    }

    public static int lcm(int x, int y) {
        return Math.abs(x * y) / gcd(x, y);

    }

    public static int gcd(int x, int y) {
        if(y == 0){
            return x;
        }

        return gcd(y, x % y);
    }
}