import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        // 배열 오름차순 정렬 후 차례대로 더한 뒤 예산 넘어가기 전에 리턴
        Arrays.sort(d);
        int count = 0;
        
        for(int i = 0; i < d.length; i++){
            budget -= d[i];
            if(budget >=0){
                count++;
            }else break;
        }
        return count;
    }
}