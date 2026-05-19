class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxL = 0, maxR = 0;
        int area = 0;

        while(left < right){
            if(maxL <= maxR){
                if(height[left] > maxL) maxL = height[left];
                else{
                    area += maxL - height[left];
                    left++;
                }
            }
            else{
                if(height[right] > maxR) maxR = height[right];
                else{
                    area += maxR - height[right];
                    right--;
                }
            }
            
        }
        return area;
        
    }
}
