import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int note1Length = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < note1Length; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int note2Length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < note2Length; j++) {
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
