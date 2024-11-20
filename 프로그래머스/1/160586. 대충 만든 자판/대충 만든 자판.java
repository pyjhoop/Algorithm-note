class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // targets가 주어졌을때 keymap 반복문 돌면서 indexOf(targets.index(0));
        for(int i = 0; i < targets.length; i++) {
            String[] arr = targets[i].split("");

            int count = 0;
            // arr 의 최소 index 찾기
            for(int j = 0; j < arr.length; j++) {
                String findStr = arr[j];

                int minIndex = Integer.MAX_VALUE;
                // keymap 반복문 돌면서 최소 index값 찾기
                for(int k = 0; k < keymap.length; k++) {
                    int index = keymap[k].indexOf(findStr);
                    if(index > -1 && minIndex > index) {
                        minIndex = index;
                    }
                }
                if (minIndex < Integer.MAX_VALUE && answer[i] != -1) {
                    answer[i] += minIndex + 1; // 인덱스를 1 기반으로 계산하여 누적
                } else {
                    answer[i] = -1; // 최소 인덱스를 찾지 못하면 결과를 -1로 설정
                }

            }
        }
        
        return answer;
    }
}