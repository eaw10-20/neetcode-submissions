class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 1) return 0;

        int profit = 0;
        int min = prices[0], max = 0;

        //[10,4,8,1,11,9,2]
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
                max = min;
            }
            else{
                if(prices[i] > max){
                    max = prices[i];
                    if(max-min > profit) profit = max-min;
                }
            }
        }
        return profit;
    }
}
