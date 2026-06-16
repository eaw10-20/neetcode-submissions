class Solution {
    public void solve(char[][] board) {
        int x = board[0].length;
        int y = board.length;
        boolean[][] marker = new boolean[y][x];

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(board[i][j] == 'O' && !marker[i][j]){
                    Stack<int[]> stack = new Stack<>();
                    Stack<int[]> conv = new Stack<>();
                    boolean fill = true;
                    stack.push(new int[]{i,j});
                    while(!stack.isEmpty()){
                        for(int a = 0; a < stack.size(); a++){
                            int[] check = stack.pop();
                            int yc = check[0];
                            int xc = check[1];
                            conv.push(check);
                            marker[yc][xc] = true;
                            if(yc == 0 || xc == 0 || yc == y-1 || xc == x-1) fill = false;
                            //check directions
                            if(yc-1 >= 0 && !marker[yc-1][xc] && board[yc-1][xc] == 'O') stack.push(new int[]{yc-1,xc});
                            if(yc+1 < y && !marker[yc+1][xc] && board[yc+1][xc] == 'O') stack.push(new int[]{yc+1,xc});
                            if(xc-1 >= 0 && !marker[yc][xc-1] && board[yc][xc-1] == 'O') stack.push(new int[]{yc,xc-1});
                            if(xc+1 < x && !marker[yc][xc+1] && board[yc][xc+1] == 'O') stack.push(new int[]{yc,xc+1});
                        }
                        
                    }
                    if(fill){
                        while(!conv.isEmpty()){
                            int[] c = conv.pop();
                            board[c[0]][c[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
}
