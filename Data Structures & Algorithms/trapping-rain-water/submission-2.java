class Solution {
    public int trap(int[] height) {
        if(height.length<=2) return 0;

        int left = 0, right;
        int totalArea = 0;

        while(height[left+1] > height[left]) left++;
        right = left+1;

        //loop for while were calculating
        while(left < height.length - 1){
            int possibleArea = 0;
            int leftHeight = height[left];
            int maxRightPosition = right, maxRightHeight = 0;
            while(right < height.length-1 && 
            (height[right+1] >= height[right] || height[right] < leftHeight)){
                if(height[right] >= maxRightHeight && height[right-1] < height[right]){
                    maxRightHeight = height[right];
                    maxRightPosition = right;
                }
                possibleArea += Math.max(0,leftHeight - height[right]);
                right++;
            }
            if(right >= height.length-1){
                if(height[right] >= maxRightHeight && height[right-1] < height[right]){
                    maxRightHeight = height[right];
                    maxRightPosition = right;
                }
                int minMax = Math.min(maxRightHeight,leftHeight);
                //go back and calc final area
                right = maxRightPosition-1;
                while(right > left){
                    totalArea += Math.max(0,minMax - height[right]);
                    right--;
                }
                left = height.length-1;
            }else{
                totalArea += possibleArea;
                left = right;
                while(left+1 < height.length-2 && height[left+1] >= height[left]) left++;
                right = left+1;
            }
        }
        return totalArea;
    }
}
