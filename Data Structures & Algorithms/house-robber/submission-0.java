class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] total = new int[len];

        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        total[0] = nums[0];
        total[1] = nums[1];
        total[2] = nums[0]+nums[2];
        if(len == 3) return Math.max(total[1],total[2]);

        for(int i = 3; i < len; i++){
            total[i] = nums[i] + Math.max(total[i-2], total[i-3]);
        }
        
        return Math.max(total[len-1], total[len-2]);
    }
}
