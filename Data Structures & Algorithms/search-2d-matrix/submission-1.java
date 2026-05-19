class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int first, last, middle, value, row;

        // search for rows 
        first = 0;
        last = matrix.length-1;
        while(last-1 > first){
            middle = (last + first)/2;
            value = matrix[middle][0];
            if(value == target) return true;
            if(value > target) last = middle-1;
            else first = middle;
        }
        if(matrix[last][0] <= target) row = last;
        else row = first;
        
        //search within row
        first = 0;
        last = matrix[row].length-1;
        while(last >= first){
            middle = (last + first)/2;
            value = matrix[row][middle];
            if(value == target) return true;
            if(value > target) last = middle-1;
            else first = middle + 1;
        }
        return false;
    }
}
