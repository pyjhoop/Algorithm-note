import java.util.*;
class Solution {
    static HashMap<String,Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        for(String str: participant) {
           map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return getIncompleName(completion, participant);
    }
    
    static String getIncompleName(String[] completion, String[] participant) {
        String answer = "";
        
         for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        for (String str : participant) {
            if (map.get(str) == 1) {
               answer = str;
            }
        }
        
        return answer;
    }
}