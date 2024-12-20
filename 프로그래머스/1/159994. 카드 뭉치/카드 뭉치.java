class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int c1 = 0;
        int c2 = 0;
        
        for(int i = 0; i < goal.length; i++) {
            String str = goal[i];
            boolean flag = false;
            if(c1 < cards1.length && cards1[c1].equals(str)) {
                c1++;
                flag = true;
            }
            
            if(c2 < cards2.length && cards2[c2].equals(str)){
                c2++;
                flag = true;
            }
            
            if(!flag) return "No";
            
        }
        return "Yes";
    }
}