class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int[] values = {map.get(target-nums[i]),i};
                return values;
            }
            map.put(nums[i],i);
        }
        int[] values = {-1,-1};
        return values;
    }
}
