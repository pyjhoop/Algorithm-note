import java.util.*;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i],i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int idx = map.get(callings[i]);
            playerSwap(players, idx);
        }
        
        return players;
    }
    
    static void playerSwap(String[] players, int idx) {
        String tmp = players[idx - 1];
        players[idx - 1] = players[idx];
        players[idx] = tmp;

        map.put(players[idx], idx);
        map.put(players[idx - 1], idx - 1);
    }
}