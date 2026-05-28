class MinStack {
    Stack<Long> s;
    long min;

    public MinStack() {
        s = new Stack();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(0L);
            min = val;
        }else{
            s.push(val-min);
            if(val < min) min = val;
        }
        System.out.println(min);
    }
    
    public void pop() {
        long r = s.pop();
        if(r < 0) min -= r; 
    }
    
    public int top() {
        long top = s.peek();
        if(top > 0) return (int) (s.peek() + min);
        return (int) min;
        
    }
    
    public int getMin() {
        return (int) min;
    }
}
