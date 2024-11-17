class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int max = health;
        int time = 0;
        int count = 0;
        
        
        for(int i = 0; i < attacks.length; i++) {
            for(int j = time; j < attacks[i][0]; j++) {
                time++;
                if(time % attacks[i][0] == 0){
                    count = 0;
                    health -= attacks[i][1];     
                    if (health <= 0) return -1;
                }else {
                    count++;
                    if(count % bandage[0] == 0){
                        health = Math.min(bandage[1] + bandage[2]+ health, max);
                    }else {
                        health = Math.min(max, health += bandage[1]);
                    }
                }
            }
        }
        return health;
    }
}