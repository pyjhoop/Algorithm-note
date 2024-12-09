import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        // 시간복잡도를 줄이기 위해 map 생성
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            String[] arr = photo[i];
            int total = 0;
            for(String str: arr){
                int val = map.get(str) != null? map.get(str):0;
                total += val;
            }
            answer[i] = total;
        }
        
        return answer;
    }
}