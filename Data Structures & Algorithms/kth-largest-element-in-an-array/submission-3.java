class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Trying quick select
        return quickSelect(0,nums.length-1,k,nums);
    }

    private int quickSelect(int left, int right, int k, int[] nums){
        int pivot = left;
        int temp;
        //swap elements to left if smaller than far right element
        for(int i = left; i < right; i++){
            if(nums[i] < nums[right]){
                temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                pivot++;
            }
        }
        //swap far right element with pivot point (where left elements are smaller)
        temp = nums[right];
        nums[right] = nums[pivot];
        nums[pivot] = temp;
        //if pivot is in right spot return, else recursive call
        if(pivot == nums.length-k) return nums[pivot];
        if(pivot > nums.length-k) return quickSelect(left,pivot-1,k,nums);
        return quickSelect(pivot+1,right,k,nums);
    }
}
