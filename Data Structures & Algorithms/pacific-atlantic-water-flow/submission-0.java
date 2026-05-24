class Solution {

    boolean[][] pacFlow;
    boolean[][] atlFlow;
    Deque<int[]> tile;
    int rows;
    int cols;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;
        pacFlow = new boolean[rows][cols];
        atlFlow = new boolean[rows][cols];
        tile = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<>();

        //for the top row
        for(int c = 0; c < cols; c++){
            tile.addFirst(new int[]{0,c});
            pacFlow[0][c] = true;
            findFlow(true,false);
        }

        //for the left col
        for(int r = 0; r < rows; r++){
            tile.addFirst(new int[]{r,0});
            pacFlow[r][0] = true;
            findFlow(true,false);
        }

        //for the bottom row
        for(int c = 0; c < cols; c++){
            tile.addFirst(new int[]{rows-1,c});
            atlFlow[rows-1][c] = true;
            findFlow(false,true);
        }

        //for the right col
        for(int r = 0; r < rows; r++){
            tile.addFirst(new int[]{r,cols-1});
            atlFlow[r][cols-1] = true;
            findFlow(false,true);
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pacFlow[r][c] && atlFlow[r][c]){
                    List<Integer> valid = new ArrayList<>();
                    valid.add(r);
                    valid.add(c);
                    ret.add(valid);
                }
            }
        }
        return ret;
    }

    void findFlow(boolean pacific, boolean atlantic){
        while(!tile.isEmpty()){
            int[] t = tile.removeLast();
            int prevHeight = heights[t[0]][t[1]];
            checkDirection(t[0]+1,t[1],prevHeight,pacific,atlantic);
            checkDirection(t[0]-1,t[1],prevHeight,pacific,atlantic);
            checkDirection(t[0],t[1]+1,prevHeight,pacific,atlantic);
            checkDirection(t[0],t[1]-1,prevHeight,pacific,atlantic);
        }
        return;
    }

    void checkDirection(int row, int col, int prevHeight, boolean pacific, boolean atlantic){
        if(row >=0 && row < rows &&
        col >= 0 && col < cols &&
        heights[row][col] >= prevHeight){
            if(pacific && !pacFlow[row][col] || atlantic && !atlFlow[row][col]){
                tile.addFirst(new int[]{row,col});
                if(pacific) pacFlow[row][col] = true;
                if(atlantic) atlFlow[row][col] = true;
            }
        }
        return;
    }
}
