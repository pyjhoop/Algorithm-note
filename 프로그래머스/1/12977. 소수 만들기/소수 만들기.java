import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int total = nums[i] + nums[j] + nums[k];
                    if(total % 2 != 0) {
                        list.add(total);
                    }
                }
            }
        }
        for(int l : list) {
            boolean flag = false;
            for(int i = 2; i < l/2; i++) {
                if(l % i == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        
        return answer;
    }
}