class KthLargest {

    private Queue<Integer> heap;
    private int count;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(k+1);
        count = k;
        for(int n: nums){
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }
        
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > count) heap.poll();
        return heap.peek();
    }
}
