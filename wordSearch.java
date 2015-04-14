public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||word==null)
            return false;
        int lenW = word.length();
        int lenBRow = board.length;
        int lenBColumn = board[0].length;
        boolean flag = false;
        int sRow = 0, sColumn = 0;
        boolean[][] mid = new boolean[lenBRow][lenBColumn];
        for(int j = 0; j < lenBRow; j++) {
            for(int k = 0; k < lenBColumn; k++) {
                if(board[j][k]==word.charAt(0)) {
                    flag = true;
                    sRow = j;
                    sColumn = k;
                    mid[sRow][sColumn]=true;
                }
            }
        }
        if(!flag)
            return flag;
        
        for(int j = 0; j < lenBRow; j++) {
            for(int k = 0; k < lenBColumn; k++) {
                if(mid[j][k]) {
                	char temp1 = board[j][k];
                	board[j][k] = '?';
                    if(isEXIST(board, j, k, word.substring(1,lenW)))
                    	return true;
                    else{
                    	board[j][k] = temp1;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isEXIST(char[][] board, int row, int column, String word) {
    	if(word.equals(""))
    		return true;
    	char temp1;
    	if(row+1<board.length&&board[row+1][column]==word.charAt(0)) {
    		temp1 = board[row+1][column];
    		board[row+1][column] = '?';
            if(isEXIST(board, row+1, column, word.substring(1,word.length())))
            	return true;
            else
            	board[row+1][column] = temp1;
        }
        if(row-1>=0&&board[row-1][column]==word.charAt(0)) {
        	temp1 = board[row-1][column];
        	board[row-1][column] = '?';
            if(isEXIST(board, row-1, column, word.substring(1,word.length())))
            	return true;
            else
            	board[row-1][column] = temp1;
        }
        if(column-1>=0&&board[row][column-1]==word.charAt(0)) {
        	temp1 = board[row][column-1];
        	board[row][column-1] = '?';
            if(isEXIST(board, row, column-1, word.substring(1,word.length())))
            	return true;
            else
            	board[row][column-1] = temp1;
        }
        if(column+1<board[0].length&&board[row][column+1]==word.charAt(0)) {
        	temp1 = board[row][column+1];
        	board[row][column+1] = '?';
            if(isEXIST(board, row, column+1, word.substring(1,word.length())))
            	return true;
            else
            	board[row][column+1] = temp1;
        }
        return false;
    }
    
}