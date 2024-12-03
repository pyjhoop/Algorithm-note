import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] arr = new int[s.length()];
        Map<String, Integer> map = new HashMap<>(){
            {
                for(int i = 'a'; i<= 'z'; i++) {
                    put(String.valueOf((char)i), -1);
                }
            }
        };

        String[] stringArr = s.split("");

        for(int i = 0; i < stringArr.length; i++){
            if(map.get(stringArr[i]) == -1){
                map.put(stringArr[i], i);
                arr[i] = -1;
            }else {
                arr[i] = i - map.get(stringArr[i]);
                map.put(stringArr[i], i);
            }
        }
        return arr;
    }
}