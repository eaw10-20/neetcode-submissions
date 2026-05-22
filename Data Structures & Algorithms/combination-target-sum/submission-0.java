class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        //assume nums is sorted for now
        for(int i = 0; i < nums.length; i++){
            List<Integer> combination = new ArrayList<>();
            ret = dfs(combination, ret,target,0,i,nums);
        }
        return ret;
    }

    public List<List<Integer>> dfs(List<Integer> combination, List<List<Integer>> ret, int target, int sum, int index, int[] nums){
        sum += nums[index];
        combination.add(nums[index]);
        //System.out.println(sum + " " + combination.toString());
        if(sum > target) return ret;
        if(sum == target){
            ret.add(new ArrayList(combination));
            return ret;
        }
        while(index < nums.length){
            ret = dfs(new ArrayList(combination), ret, target, sum, index, nums);
            index++;
        }
        
        return ret;

    }
}
