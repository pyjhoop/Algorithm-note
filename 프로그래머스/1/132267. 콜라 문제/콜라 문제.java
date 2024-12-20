class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // 반환받는 총 콜라수, 빈병 구하고
        // 반환받는 총 콜라수 또한 빈병이 될 예정이기에 n을 반환받은 콜라수 + 빈병으로 설정 후 n이 a-1 초과 조건동안 반복문 

        while(n > a - 1) {
            answer += (n / a) * b;
            n = n % a + ((n / a) * b);
        }
        
        return answer;
    }
}