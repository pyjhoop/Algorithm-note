class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(c >= 'a' && c<= 'z') {
                 char result = (char) (c+n > 'z'? 'a' + (c+n-'z'-1): c+n);
                 sb.append(result);
            }else if(c >= 'A' && c <= 'Z') {
                 char result = (char) (c+n > 'Z'? 'A' + (c+n-'Z'-1): c+n);
                 sb.append(result);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}