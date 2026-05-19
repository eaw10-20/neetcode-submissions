class Solution {
    public int maxArea(int[] heights) {

        int first = 0;
        int last = heights.length-1;
        int max = 0;

        while(first < last){
            int minHeight = Math.min(heights[last], heights[first]);
            int area = (last - first) * minHeight;
            if(area > max) max = area;
            if(heights[first] == minHeight){
                int f = heights[first];
                do{
                    first++;
                }while(first < last && heights[first] <= f);
            } 
            else{
                int l = heights[last];
                do{
                    last--;
                }while(first < last && heights[last] <= l);
            } 
        }
        return max;
    }
}
