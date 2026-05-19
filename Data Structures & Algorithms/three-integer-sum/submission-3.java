class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Sort the array
        List<Integer> numList = new ArrayList<>();
        for(int n: nums){
            numList.add(n);
        }
        numList.sort(null);
        //contains list of 3sum to be returned
        List<List<Integer>> ret = new ArrayList<>();

        //loop through array taking one value and "2 pointering" the other two values
        for(int i = 0; i < numList.size()-2; i++){
            int start = i+1;
            int end = numList.size()-1;
            while(start<end){
                int value = numList.get(start) + numList.get(end) + numList.get(i);
                if(value == 0){
                    List<Integer> tSum = new ArrayList<>();
                    tSum.add(numList.get(i));
                    tSum.add(numList.get(start));
                    tSum.add(numList.get(end));
                    ret.add(tSum);
                    //check here for duplicate values
                    int lastStart = numList.get(start);
                    while(start < end && numList.get(start) == lastStart) start++;
                    int lastEnd = numList.get(end);
                    while(start < end && numList.get(end) == lastEnd) end--;
                }else if(value < 0) start++;
                else end--;
            }
            while(i < numList.size()-2 && numList.get(i).equals(numList.get(i+1))) i++;
        }
        return ret;
    }
}