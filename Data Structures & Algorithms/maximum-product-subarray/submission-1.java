class Solution {
    public int maxProduct(int[] nums) {

        int cMax = nums[0];
        if(nums.length == 1) return cMax;

        int max = cMax;
        int cMin = cMax;

        for(int i = 1; i < nums.length; i++){
            int temp = cMax;
            cMax = Math.max(Math.max(nums[i]*cMax, nums[i]),nums[i]*cMin);
            cMin = Math.min(Math.min(nums[i]*temp, nums[i]),nums[i]*cMin);

            max = Math.max(max,cMax);
        }

        return max;
    }
}

//[-2,3,-4,0,1]
//max = 3
//cMax = -4
//cMin = -6

//temp = 3