class Solution {
    int max;
    Set<Integer> checked = new HashSet<>();
    int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        max = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1 && !checked.contains(r*grid[0].length+c)){
                    //check for surrounding cells
                    int size = 1;
                    size = bfs(grid,r,c,size);
                    max = Math.max(max,size);
                }
            }
        }
        return max;
    }

    int bfs(int[][] grid, int r, int c, int size){
        checked.add(r*grid[0].length+c);
        for(int[] d: direction){
            int rd = r+d[0];
            int cd = c+d[1];
            if(rd >=0 && rd < grid.length && cd >=0 && cd < grid[0].length){
                if(grid[rd][cd] == 1 && !checked.contains(rd*grid[0].length+cd)){
                    size++;
                    checked.add(rd*grid[0].length+cd);
                    size = bfs(grid,rd,cd,size);
                }
            }
        }
        return size;
    }
}

//check for an island by checking each cell

//if an island is found check cells around it for more land

//for each land increase the size

//if size is max then replace the previous max
