class Solution {

    private List<List<Integer>> subsets;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets = new ArrayList<>();

        dfs(nums,new ArrayList<>(),0);
        return subsets;
    }

    private void dfs(int[] nums, List<Integer> sub, int level){
        //return if at end of nums
        if(level == nums.length){
            subsets.add(new ArrayList(sub));
            return;
        }

        //dfs while adding current value
        sub.add(nums[level]);

        dfs(nums,sub,level+1);

        //dfs while not including current value
        sub.remove((Integer)nums[level]);
        do{
            level++;
        }while(level < nums.length && nums[level] == nums[level-1]);
        dfs(nums,sub,level);

        return;
    }
}
