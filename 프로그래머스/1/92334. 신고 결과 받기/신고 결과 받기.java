import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idMap = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        // idMap 세팅
        for(int i = 0; i < id_list.length; i++){
            idMap.put(id_list[i], i);
        }

        //reportMap 세팅
        for(int i = 0; i < report.length; i++) {
            String[] arr = report[i].split(" ");
            String reporter = arr[0];
            String receiver = arr[1];
            if(reportMap.get(receiver) == null){
                Set<String> list = new HashSet<>();
                list.add(reporter);
                reportMap.put(receiver, list);
            }else {
                Set<String> list = reportMap.get(receiver);
                list.add(reporter);
                reportMap.put(receiver, list);
            }
        }

        // reportMap 반복문 돌면서 List 사이즈가 k 이상이면 reporter index++;
        for(String reporter: reportMap.keySet()){
            Set<String> set = reportMap.get(reporter);
            if(set.size() >= k){
                for(String s: set){
                    Integer index = idMap.get(s);
                    answer[index]++;
                }
            }
        }
        
        return answer;
    }
}