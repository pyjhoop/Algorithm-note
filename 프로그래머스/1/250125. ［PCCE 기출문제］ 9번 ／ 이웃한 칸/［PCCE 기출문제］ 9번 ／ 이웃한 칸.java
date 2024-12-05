class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        String target = board[h][w];
        
        if(h-1 >= 0 && board[h-1][w].equals(target)) answer++;
        if(h+1 <= n-1 && board[h+1][w].equals(target)) answer++;
        
        if(w-1 >= 0 && board[h][w-1].equals(target)) answer++;
        if(w+1 <= n-1 && board[h][w+1].equals(target)) answer++;
        
        return answer;
    }
}