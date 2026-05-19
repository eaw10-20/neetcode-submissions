class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //<num, count>
        HashMap<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> freqList = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) freqList.add(null);
        int[] ret = new int[k];
        //Take all nums and put them into a hashmap that stores the count of each number
        for(int num: nums){
            if(count.containsKey(num)){
                count.put(num,count.get(num) + 1);
            }else{
                count.put(num,1);
            }
        }
        //Go through each value in the hashmap and associate it with an index in the array
        for(Integer key: count.keySet()){
            int frequency = count.get(key);
            if(freqList.get(frequency) != null){
                List<Integer> thisCount = freqList.get(frequency);
                thisCount.add(key);
            }else{
                List<Integer> thisCount = new ArrayList<>();
                thisCount.add(key);
                freqList.set(frequency, thisCount);
            }
            
        }

        //loop through freqList and get the k highest values
        int index = 0;
        for(int i = nums.length; i >= 0; i--){
            if(freqList.get(i) != null){
                for(Integer value: freqList.get(i)){
                    if (index < k) {
                        ret[index++] = value;
                    }
                }
            }
            if(index == k) return ret;
        }
        return ret;
    }
}