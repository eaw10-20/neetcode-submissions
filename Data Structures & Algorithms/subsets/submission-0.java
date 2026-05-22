class Solution {

    List<List<Integer>> allSets;
    int level;

    public List<List<Integer>> subsets(int[] nums) {
        level = 1;
        allSets = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Stack<Integer> subset = new Stack<>();

        dfs(subset,nums);
        return allSets;
    }

    void dfs(Stack<Integer> subset, int[] nums){
        if(level > nums.length){
            allSets.add(new ArrayList<>(subset));
            level--;
            return;
        }
        //include value
        subset.push(nums[level-1]);
        level++;
        dfs(subset, nums);

        //don't include value
        subset.pop();
        level++;
        dfs(subset, nums);

        level--;
        return;
    }
}
