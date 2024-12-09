class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] arr = new boolean[n];
        
        //1번은 0인덱스야.
        for(int i : section){
            arr[i-1] = true;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]){
                i += (m-1);
                answer++;
            }
        }
        
        
        return answer;
    }
}