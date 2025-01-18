
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] strings = new String[5];
        int maxLength = 0;

        for (int i = 0; i < 5; i++) {
            strings[i] = sc.nextLine();
            if (strings[i].length() > maxLength) {
                maxLength = strings[i].length();
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < strings[j].length()) {
                    result.append(strings[j].charAt(i));
                }
            }
        }

        System.out.println(result.toString());
    }
}
