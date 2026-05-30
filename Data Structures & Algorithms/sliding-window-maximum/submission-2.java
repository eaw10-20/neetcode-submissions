class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> storage = new ArrayDeque<>();
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        int l = 0, r = 0;

        while(r < len){
            while(!storage.isEmpty() && nums[storage.getLast()] < nums[r]) storage.removeLast();
            storage.addLast(r);

            if(l > storage.getFirst()) storage.removeFirst();
            if((r+1) >= k){
                ret[l] = nums[storage.getFirst()];
                l++;
            }
            r++;
        }
        

        return ret;
    }
}
