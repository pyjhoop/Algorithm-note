import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
         Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        
        for(int i = 0; i < moves.length; i++) {
            int pickIndex = moves[i] - 1;
            int pickResult = 0;
            
            for(int j = 0; j < board.length; j++) {
                if(board[j][pickIndex] != 0) {
                    pickResult = board[j][pickIndex];
                    board[j][pickIndex] = 0;
                    break;
                }
            }
            if(pickResult == 0) continue;
            
            if(stack.isEmpty()){
                stack.addLast(pickResult);
            }else {
                int temp = stack.peekLast();
                if(temp == pickResult) {
                    stack.removeLast();
                    count += 2;
                }else {
                    stack.addLast(pickResult);
                }
            }
            
        }
        return count;
    }
}