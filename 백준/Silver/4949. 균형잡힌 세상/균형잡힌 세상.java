import java.io.*;
import java.util.*;

public class Main {
    static Deque<Character> stack = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;

            if(checkMatch(str)){
                sb.append("yes\n");
            }else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    // 배열 사용할때 크기랑 시간은 어떻게 나오는지도 체크해보자
    private static boolean checkMatch(String str) {
        stack.clear();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '['){
                stack.addLast(c);
            }else if(c == ')'){
                if (stack.isEmpty() || stack.peekLast() != '(') {
                    return false; // 스택이 비었거나 짝이 맞지 않을 때
                }
                stack.pollLast();
            }else if(c == ']'){
                if (stack.isEmpty() || stack.peekLast() != '[') {
                    return false; // 스택이 비었거나 짝이 맞지 않을 때
                }
                stack.pollLast();
            }
        }

        return stack.isEmpty();
    }

}