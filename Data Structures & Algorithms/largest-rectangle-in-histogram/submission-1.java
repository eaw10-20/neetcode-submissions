class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        //[height,index]

        for(int i = 0; i < heights.length; i++){
            int index = i;
            while(stack.size() > 0 && stack.peek()[0] > heights[i]){
                int[] height = stack.pop();
                maxArea = Math.max(maxArea, (i-height[1])*height[0]);
                index= height[1];
            }
            
            stack.push(new int[]{heights[i],index});
        }

        while(stack.size() > 0){
            int[] height = stack.pop();
            maxArea = Math.max(maxArea, height[0]*(heights.length-height[1]));
        }

        return maxArea;
    }
}

// Add first bar to stack
// While there are still heights to add...
//      If previous height is higher compare with existing max area
//      Set index to previous index in stack +1
// While heights in stack
//      Get area height x heights.len - index & compare with max
// return max