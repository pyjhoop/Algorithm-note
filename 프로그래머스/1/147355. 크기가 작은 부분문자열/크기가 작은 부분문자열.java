class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long pVal = Long.parseLong(p);
        int sIndex = 0;
        int eIndex = p.length() - 1;
        
        while(eIndex < t.length()){
            Long val = Long.parseLong(t.substring(sIndex, eIndex+1));
            if(val <= pVal) answer++;
            sIndex++;
            eIndex++;
        }
        return answer;
    }
}