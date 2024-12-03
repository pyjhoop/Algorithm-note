class Solution {
    public int solution(String[] order) {
        int price = 0;
        for(String str: order){
            if(str.contains("americano") || str.contains("anything")){
                price += 4500;
            }else {
                price += 5000;
            }
        }
        return price;
    }
}