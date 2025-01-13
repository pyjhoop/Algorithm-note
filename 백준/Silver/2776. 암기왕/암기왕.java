import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int note1Length = Integer.parseInt(br.readLine());
            String[] note1Arr = br.readLine().split(" ");
            HashMap<String, Integer> map = new HashMap<>();

            for(int j = 0; j < note1Length; j++) {
                map.putIfAbsent(note1Arr[j], j);
            }

            int note2Length = Integer.parseInt(br.readLine());
            String[] note2Arr = br.readLine().split(" ");

            for(String note2Num : note2Arr) {
                if(map.get(note2Num) != null){
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