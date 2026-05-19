class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> convertedNums = new ArrayList<>();
        for(int n: nums){
            convertedNums.add(n);
        }
        Set<Integer> all = new HashSet<>(convertedNums);
        HashMap<Integer, Integer> used = new HashMap<>(); //arrayNum, sequenceLength
        int longestSequence = 0;


        for(int n: nums){
            if(!used.containsKey(n)){
                int counter = 1;
                while(all.contains(n+counter)){
                    if(used.containsKey(n+counter)){
                        counter += used.get(n+counter);
                    }else{
                        used.put(n+counter,counter+1);
                        counter++;
                    }
                }
                used.put(n,counter);
                if(counter > longestSequence) longestSequence = counter;
            }
        }
        return longestSequence;
    }
}
