class Solution {
    private int n;

    public void rotate(int[][] matrix) {
        n = matrix.length;
        int mid = n/2;

        for(int y = 0; y < mid; y++){
            for(int x = 0; x < mid; x++){
                swap(x,y,matrix);
            }
            if(n%2 == 1){
                swap(mid,y,matrix);
            }
        }
        
    }

    private void swap(int x, int y, int[][] matrix){
        int temp = matrix[y][x];
        matrix[y][x] = matrix[n-x-1][y];
        matrix[n-x-1][y] = matrix[n-y-1][n-x-1];
        matrix[n-y-1][n-x-1] = matrix[x][n-y-1];
        matrix[x][n-y-1] = temp;
    }
}