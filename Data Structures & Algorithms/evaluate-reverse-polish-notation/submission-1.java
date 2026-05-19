class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> myStack = new Stack();
        for(String t: tokens){
            if(t.equals("+")){
                myStack.push(myStack.pop() + myStack.pop());
            }
            else if(t.equals("-")){
                int hold = myStack.pop();
                myStack.push(myStack.pop() - hold);
                
            }
            else if(t.equals("*")){
                myStack.push(myStack.pop() * myStack.pop());
                
            }
            else if(t.equals("/")){
                int hold = myStack.pop();
                myStack.push(myStack.pop() / hold);
            }
            else{
                myStack.push(Integer.parseInt(t));
            }
        }
        return myStack.pop();
    }
}
