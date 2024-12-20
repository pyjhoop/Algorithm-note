import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        // skip 문자를 빠르게 조회하기 위해 map 선언
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < skip.length(); i++) {
            map.putIfAbsent(skip.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            char c = s.charAt(i);
            while(count < index){
                c++;
                if (c > 'z') c = 'a';     
                if(map.get(c) == null)  count++;
            }
            sb.append(c);
        }
        
        
        return sb.toString();
    }
}