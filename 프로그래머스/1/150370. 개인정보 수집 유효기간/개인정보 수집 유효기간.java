import java.util.*;
import java.time.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todays = LocalDate.parse(today.replaceAll("\\.", "-"));

        Map<String, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(String term: terms) {
            String[] arr = term.split(" ");
            map.put(arr[0], arr[1]);
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            String date = arr[0];
            String term = arr[1];

            LocalDate privacyDate = LocalDate.parse(date.replaceAll("\\.", "-"));
            String month = map.get(term);
            LocalDate expireDate = privacyDate.plusMonths(Integer.parseInt(month)).minusDays(1);
            if(expireDate.isBefore(todays)){
                list.add(i+1);
            }

        }
        list.stream().sorted();
        
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        
        return arr;
        
    

        
    }
}