import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int note1Length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] note1Arr = new int[note1Length];
            for(int j = 0; j < note1Length; j++) {
                note1Arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1Arr);

            int note2Length = Integer.parseInt(br.readLine());
            int[] note2Arr = new int[note2Length];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < note2Length; j++) {
                note2Arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int note2: note2Arr) {
                int start = 0;
                int end = note1Length - 1;
                int mid = end / 2;

                boolean flag = false;
                while(start <= end) {
                    if(note1Arr[mid] > note2){
                        end = mid - 1;
                        mid = (start + end) / 2;
                    }else if(note1Arr[mid] < note2) {
                        start = mid + 1;
                        mid = (start + end) / 2;
                    }else {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
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