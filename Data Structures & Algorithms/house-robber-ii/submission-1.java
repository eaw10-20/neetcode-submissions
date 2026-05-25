class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] total = new int[len];

        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        total[0] = nums[0];
        total[1] = nums[1];
        total[2] = nums[0]+nums[2];
        if(len == 3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);

        
        for(int i = 3; i < len-1; i++){
            total[i] = nums[i] + Math.max(total[i-2], total[i-3]);
        }
        int leftToRight = Math.max(total[len-2], total[len-3]);
        total = new int[len];

        total[len-1] = nums[len-1];
        total[len-2] = nums[len-2];
        total[len-3] = nums[len-1]+nums[len-3];
        for(int i = len-4; i > 0; i--){
            total[i] = nums[i] + Math.max(total[i+2], total[i+3]);
        }
        int rightToLeft = Math.max(total[1], total[2]);
        
        return Math.max(leftToRight, rightToLeft);
    }
}
