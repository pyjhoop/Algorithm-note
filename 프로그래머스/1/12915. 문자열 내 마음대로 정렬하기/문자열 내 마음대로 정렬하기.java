import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> arr = new ArrayList<>();
        
        for(String str: strings) {
            arr.add(String.valueOf(str.charAt(n))+str);
        }
        
        Collections.sort(arr);
        
        for(int i = 0; i< arr.size(); i++){
            arr.set(i, arr.get(i).substring(1, arr.get(i).length()));
        }
        
        String[] answer = arr.toArray(new String[0]);
       
        return answer;
    }
}