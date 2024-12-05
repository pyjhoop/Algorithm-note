class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        
        while(true){
            int bMax = Math.max(bill[0], bill[1]);
            int bMin = Math.min(bill[0], bill[1]);
            
            if(bMax > walletMax || bMin > walletMin){
                bMax /= 2;
                answer++;
                bill[0] = bMax;
                bill[1] = bMin;
            }else break;
        }
        
        return answer;
    }
}