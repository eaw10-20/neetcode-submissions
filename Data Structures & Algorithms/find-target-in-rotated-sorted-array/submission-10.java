class Solution {
    public int search(int[] nums, int target) {
        int rot = -1;
        int start = 0, end = nums.length-1;
        int mid = -1;
        //find the middle
        while(rot == -1){
            mid = (start+end)/2;
            if(mid == 0 && end == 0) rot = 0;
            else{
                if(nums[mid] > nums[mid+1]) rot = mid+1;
                else if(nums[mid] > nums[end]) start = mid+1;
                else end = mid;
            }
        }
        
        //check if target is left or right of middle
        if(target > nums[nums.length-1]){
            start = 0;
            end = rot-1;
        }else{
            start = rot;
            end = nums.length-1;
        }

        //binary search to find target
        while(start < end){
            mid = (start+end)/2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid]) end = mid-1;
            else start = mid+1;
        }

        if(nums[start] == target) return end;
        return -1;
    }
}
