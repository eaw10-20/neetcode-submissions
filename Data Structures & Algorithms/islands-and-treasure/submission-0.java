class Solution {
    Deque<int[]> tiles;
    Set<Integer> checked;
    int rows;
    int cols;

    public void islandsAndTreasure(int[][] grid) {

        tiles = new ArrayDeque<>();
        rows = grid.length;
        cols = grid[0].length;
        checked = new HashSet<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0) tiles.push(new int[]{i,j});
            }
        }
        int val = 0;
        int lengthOfQueue;
        while(!tiles.isEmpty()){
            val++;
            lengthOfQueue = tiles.size();
            for(int i = 0; i < lengthOfQueue; i++){
                int[] tile = tiles.removeLast();
                addToGrid(tile[0]+1,tile[1],val,grid);
                addToGrid(tile[0]-1,tile[1],val,grid);
                addToGrid(tile[0],tile[1]+1,val,grid);
                addToGrid(tile[0],tile[1]-1,val,grid);
            }
        }
        return;
    }

    public void addToGrid(int row, int col, int val, int[][] grid){
        if(row >= 0 && row < rows &&
            col >= 0 && col < cols &&
            grid[row][col] > 0 && !checked.contains(row*cols + col)){
                grid[row][col] = val;
                checked.add(row*cols + col);
                tiles.addFirst(new int[]{row,col});
            }
            return;
    }
}

//bfs

//scan for treasure chest

//store chests in queue
//count up to store distances from chest

//[ x,-1 ,0, x]
//[ x, x, x,-1]
//[ x,-1, x,-1]
//[ 0,-1, x, x]
