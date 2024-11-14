import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
       HashMap<String, List<String>> map = new HashMap<>();

        // map 세팅
        for(int i = 'a'; i <= 'z'; i++) {
            map.put(String.valueOf((char)i), new ArrayList<>());
        }

        // map 세팅
        for(String str: strings) {
            String key = String.valueOf(str.charAt(n));
            map.get(key).add(str);
        }

        // map 정렬
        for(List<String> list: map.values()) {
            Collections.sort(list);
        }

        // maptoList
        List<String> answer = new ArrayList<>();
        for(int i = 'a'; i <= 'z'; i++) {
            answer.addAll(map.get(String.valueOf((char)i)));
        }

        String[] arr = answer.toArray(new String[0]);
        return arr;
    }
}