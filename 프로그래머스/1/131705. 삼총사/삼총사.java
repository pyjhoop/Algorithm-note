class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int i = 0, j = 1, k = 2;
        
        while (i < number.length - 2) {
            int sum = number[i] + number[j] + number[k];
            
            if (sum == 0) {
                answer++;
            }
            
            // 다음 인덱스 이동
            if (k < number.length - 1) {
                k++;
            } else if (j < number.length - 2) {
                j++;
                k = j + 1;
            } else {
                i++;
                j = i + 1;
                k = j + 1;
            }
        }
        
        return answer;
    }
}