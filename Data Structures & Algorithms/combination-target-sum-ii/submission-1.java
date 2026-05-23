class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        ArrayList<Integer> group = new ArrayList<>(); 
        Arrays.sort(candidates);
        dfs(group,0,candidates,target);
        return res;
    }

    private void dfs(ArrayList<Integer> group, int i, int[] candidates, int target){
        if(target == 0) res.add(new ArrayList(group));
        if(target <= 0 || i > candidates.length){
            return;
        }

        for(int p = i; p < candidates.length; p++){
            if(p > i && candidates[p] == candidates[p-1]) continue;
            group.add(candidates[p]);
            dfs(group,p+1,candidates,target-candidates[p]);
            group.removeLast();
        }
        return;
    }
}
