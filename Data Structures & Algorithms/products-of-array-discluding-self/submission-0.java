class Solution {
    public int[] productExceptSelf(int[] nums) {
        int all = 1;
        boolean firstFlag = false;
        for(int n: nums){
            if(n == 0 && firstFlag == false) firstFlag = true;
            else all *= n;
        }

        int[] prodXSelf = new int[nums.length];
        if(firstFlag == true && all == 0){
            for(int i = 0; i < nums.length; i++) prodXSelf[i] = 0;
            return prodXSelf;
        }
        for(int i = 0; i < nums.length; i++){
            if(firstFlag && nums[i] != 0) prodXSelf[i] = 0;
            else if(firstFlag) prodXSelf[i] = all;
            else prodXSelf[i] = all/nums[i];
        }
        return prodXSelf;
    }
}  
