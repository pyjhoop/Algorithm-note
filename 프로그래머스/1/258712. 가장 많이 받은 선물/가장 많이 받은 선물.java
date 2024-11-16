import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>();
        int[][] arr = new int[friends.length][friends.length];
        int[] giftsIndex = new int[friends.length];
        int[] giftsResult = new int[friends.length];
        // 1. 맵 초기화
        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], i);
        }
        // 2. 이중 배열초기화 - gifts이용해서
        for(String str: gifts) {
            String[] names = str.split(" ");
            int senderIndex = map.get(names[0]);
            int receiverIndex = map.get(names[1]);
            arr[senderIndex][receiverIndex]++;
            // 여기서 선물지수 초기화해야함.
            giftsIndex[senderIndex]++;
            giftsIndex[receiverIndex]--;
        }
        
        // 2중 반복문을 통해 받을 선물 개수 조건문에 따라 구현
        // a, b 선물 주고받으면 덜준 사람이 더 준사람에게 선물 줌.
        // a, b 선물 서로 안주거나 주고 받은 선물의 개수가 동일하면 지수가 작은 사람이 큰사람에게 줌. but, 지수가 동일하면 안줘도됨
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                // 나자신은 무시
                if(j == i) continue;
                // 먼저 0,1에서 선물 받은 개수 구해보자
                int iCount = arr[i][j];
                int jCount = arr[j][i];
                
                if(iCount > jCount) {
                    giftsResult[i]++;
                }else if(jCount > iCount) {
                    giftsResult[j]++;
                }else if(jCount == iCount) {
                    // 지수를 구해야함.
                    int iIndex = giftsIndex[i];
                    int jIndex = giftsIndex[j];
                    if(iIndex > jIndex) {
                        giftsResult[i]++;
                    }else if(jIndex > iIndex){
                        giftsResult[j]++;
                    }
                }
                
            }
        }
        
        // giftsResult 반복문 돌려서 최대값을 찾아야함.
        int max = 0;
        for(int i: giftsResult){
            max = Math.max(max, i);
        }
        
        return max/2;
    }
}