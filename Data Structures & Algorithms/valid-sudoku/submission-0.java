class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for(int i = 0; i < 9; i++){
            HashSet<Character> repeat = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char input = board[i][j];
                if(repeat.contains(input) && input != '.') return false;
                repeat.add(input);
            }
        }
        
        //check columns
        for(int j = 0; j < 9; j++){
            HashSet<Character> repeat = new HashSet<>();
            for(int i = 0; i < 9; i++){
                char input = board[i][j];
                if(repeat.contains(input) && input != '.') return false;
                repeat.add(input);
            }
        }

        //check cubes
        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                HashSet<Character> repeat = new HashSet<>();
                for(int a = i; a < i+3; a++){
                    for(int b = j; b < j+3; b++){
                        char input = board[a][b];
                        if(repeat.contains(input) && input != '.') return false;
                        repeat.add(input);
                    }
                }
            }
        }

        return true;
    }
}
