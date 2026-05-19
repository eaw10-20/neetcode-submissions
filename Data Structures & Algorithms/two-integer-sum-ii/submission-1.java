class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] ret = new int[2];

        while(end > start){
            if(numbers[start] + numbers[end] == target){
                ret[0] = start+1;
                ret[1] = end+1;
                return ret;
            }
            if(numbers[start] + numbers[end] < target) start++;
            else if(numbers[start] + numbers[end] > target) end--;
        }
        return ret;
        
    }
}
