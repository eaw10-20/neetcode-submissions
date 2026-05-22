class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s: stones) maxHeap.add(s);
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            first -= second;
            if(first > 0) maxHeap.add(first);
        }
        if(maxHeap.isEmpty()) return 0;
        return maxHeap.poll();
    }
}
