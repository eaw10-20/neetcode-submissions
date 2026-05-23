class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int islands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    //search here
                    islands++;
                    grid = search(grid,row,col);
                }
            }
        }
        return islands;
    }

    char[][] search(char[][] grid, int row, int col){
        grid[row][col] = '0';
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row,col});
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i < length; i++){
                int[] island = queue.removeLast();
                for(int[] d: directions){
                    int y = island[0] + d[0];
                    int x = island[1] + d[1];
                    if(y >= 0 && y < grid.length && x >= 0 && x < grid[0].length){
                        if(grid[y][x] == '1'){
                            queue.add(new int[]{y,x});
                            grid[y][x] = '0';
                        }
                    }
                }
            }
        }
        return grid;
    }
}
