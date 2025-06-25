import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = 0;
        int max = 0;
        int maxIndex = 1;
        for(int i = 1; i <= 9; i++) {
            temp = Integer.parseInt(br.readLine());
            if(temp > max) {
                maxIndex = i;
                max = temp;
            }
        }

        System.out.println(max);
        System.out.println(maxIndex);
        br.close();
    }
}