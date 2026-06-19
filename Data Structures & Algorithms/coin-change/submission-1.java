class Solution {
    public int coinChange(int[] coins, int amount) {

        // create array for number of coints needed for amount from 0 up to amount
        // 0 is needed for 0, fill rest with large number of coins (amount + 1)
        int[] coinCount = new int[amount+1];
        Arrays.fill(coinCount,amount+1);
        coinCount[0] = 0;

        // loop for each amount value, using dp to store previous values 
        // check each coin for each value
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    coinCount[i] = Math.min(coinCount[i],coinCount[i-coin]+1);
                }
            }
        }

        // if large value no coin value is found so return -1
        return coinCount[amount] > amount ? -1 : coinCount[amount];
    }
}
