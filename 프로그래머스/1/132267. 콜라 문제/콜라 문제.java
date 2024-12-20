class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // n: 빈병, a: 제출 빈병 b: 반환 콜라
        // 몫, 나머지 
        // 20 -> 10 > 5 > 2,1(3) > 1,1(2) > 1
        
        while(n > a - 1) {
            int cok = (n / a) * b;
            int restBlank = n % a;
            answer += cok;
            n = restBlank + cok;
        }
        
        return answer;
    }
}