import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] arr = new int[s.length()];
        Map<String, Integer> map = new HashMap<>();
        String[] stringArr = s.split("");

        for(int i = 0; i < stringArr.length; i++){
            arr[i] = i-map.getOrDefault(stringArr[i],i+1);
            map.put(stringArr[i], i);
        }
        return arr;
    }
}