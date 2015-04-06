public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
    	int length1 = board.length;
    	int length2 = board[0].length;
        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                if(board[i][j]=='O'&&(i==0||j==0||i==length1 - 1||j==length2 - 1)) {
                	flipRegion(board, i, j);
                }
            }
        }
        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                if(board[i][j]=='O') {
                	board[i][j]='X';
                }
                if(board[i][j]=='#') {
                	board[i][j]='O';
                }                
            }
        }
    }
    
    public void flipRegion(char[][] board, int i, int j) {
    	int length1 = board.length;
    	int length2 = board[0].length;
    	if(board[i][j]=='O')
    		board[i][j] = '#';
    	if(i < length1 - 1 && board[i+1][j]=='O')
    		flipRegion(board, i+1 , j);
    	if(i > 0 && board[i-1][j]=='O')
    		flipRegion(board, i-1 , j);
    	if(j > 1 && board[i][j-1]=='O')
    		flipRegion(board, i , j-1);
    	if(j < length2 -1 &&board[i][j+1]=='O')
    		flipRegion(board, i , j+1);
    }
}