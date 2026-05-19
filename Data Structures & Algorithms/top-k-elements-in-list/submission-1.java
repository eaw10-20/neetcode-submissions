class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //fill map <number, count>
        for(int n: nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
        }

        //put numbers in array and sort
        List<Integer> sortNums = new ArrayList<>(map.keySet());
        sortNums.sort((a,b) -> map.get(b) - map.get(a));

        //return array with most frequent numbers
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            ret[i] = sortNums.get(i);
        }
        return ret;
    }
}
