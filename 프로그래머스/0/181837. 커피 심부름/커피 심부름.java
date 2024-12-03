class Solution {
    public int solution(String[] order) {
       int price = 0;
        for(String str: order){
            price += str.contains("cafelatte") ?  5000 :  4500;
        }
        return price;
    }
}