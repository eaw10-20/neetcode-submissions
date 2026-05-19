class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>(); //[temperature, day]

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty()){
                if(stack.peek()[0] < temperatures[i]){
                    int initDay = stack.pop()[1];
                    ret[initDay] = i - initDay;
                }
                else break;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return ret;
    }
}
