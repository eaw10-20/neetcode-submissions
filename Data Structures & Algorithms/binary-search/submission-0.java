class Solution {
    public int search(int[] nums, int target) {
        int first = 0, last = nums.length-1, middle, check;

        do{
            middle = (last+first)/2;
            check = nums[middle];
            if(check == target) return middle;
            if(check > target){
                last = middle-1;
            }
            else{
                first = middle+1;
            }
        }while(last >= first);
        return -1;
        
    }
}
