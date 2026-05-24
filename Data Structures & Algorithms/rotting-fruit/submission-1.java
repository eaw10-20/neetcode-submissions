class Solution {

    int rows;
    int cols;
    Deque<int[]> newRotten;
    int[][] grid;

    public int orangesRotting(int[][] grid) {

        int min = 0;
        newRotten = new ArrayDeque<>();
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2) newRotten.addFirst(new int[]{r,c});
            }
        }
        
        while(!newRotten.isEmpty()){
            int cycle = newRotten.size();
            for(int i = 0; i < cycle; i++){
                int[] coord = newRotten.removeLast();
                updateGrid(coord[0]+1,coord[1]);
                updateGrid(coord[0]-1,coord[1]);
                updateGrid(coord[0],coord[1]+1);
                updateGrid(coord[0],coord[1]-1);
            }
            if(!newRotten.isEmpty()) min++;
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1) return -1;
            }
        }
        return min;
    }

    public void updateGrid(int row, int col){
        if(row >=0 && row < rows &&
        col >= 0 && col < cols &&
        grid[row][col] == 1){
            grid[row][col] = 2;
            newRotten.addFirst(new int[]{row,col});
        }
        return;
    }
}

//check if there are any rotten fruit and add to queue
//increment and rot surrounding fruit, add new fruit to queue
//loop until no more fruit
//check for fresh fruit