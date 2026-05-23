class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Boolean> marker = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            marker.add(false);
        }

        for(int i = 0; i < nums.length; i++){
            List<Integer> permutation = new ArrayList<>(nums.length);
            
            collector(permutation,marker,nums,i);
        }
        return res;
    }

    private void collector(List<Integer> permutation, List<Boolean> marker,int[] nums, int i){
        boolean filled = true;
        permutation.add(nums[i]);
        marker.set(i,true);
        for(int p = 0; p < nums.length; p++){
            if(!marker.get(p)){
                filled = false;
                collector(permutation,marker,nums,p);
            }
        }
        if(filled) res.add(new ArrayList(permutation));

        int last = permutation.size()-1;
        permutation.remove(last);
        marker.set(i,false);
        return;
    }
}
