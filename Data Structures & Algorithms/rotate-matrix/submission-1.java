class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int mid = n/2;
        int temp;

        for(int y = 0; y < mid; y++){
            for(int x = 0; x < mid; x++){
                temp = matrix[y][x];
                matrix[y][x] = matrix[n-x-1][y];
                matrix[n-x-1][y] = matrix[n-y-1][n-x-1];
                matrix[n-y-1][n-x-1] = matrix[x][n-y-1];
                matrix[x][n-y-1] = temp;
            }
            if(n%2 == 1){
                temp = matrix[y][mid];
                matrix[y][mid] = matrix[mid][y];
                matrix[mid][y] = matrix[n-y-1][mid];
                matrix[n-y-1][mid] = matrix[mid][n-y-1];
                matrix[mid][n-y-1] = temp;
            }
        }
        
    }
}

//x -> y'
//y -> x

// [yx]

// [00][01][02]
// [10][11][12]
// [20][21][22]

// dealing with mid on even n's
// y mid "="?