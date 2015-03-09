public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i, j;
        HashSet hash = new HashSet();
        char ch;
        for(i = 0; i < 9; i++) {
            hash = new HashSet();
            for(j = 0; j < 9; j++) {
                ch = board[i][j];
                if(ch>='0'&&ch<='9') {
                    if(hash.contains(ch))
                        return false;
                    hash.add(ch);                    
                }
            }
        }
        for(i = 0; i < 9; i++) {
            hash = new HashSet();
            for(j = 0; j < 9; j++) {
                ch = board[j][i];
                if(ch>='0'&&ch<='9') {
                    if(hash.contains(ch))
                        return false;
                    hash.add(ch);                    
                }
            }
        }
        int l, k;
        for(l = 0; l < 3; l++) {
            for(k = 0; k < 3; k++) {
                hash = new HashSet();
                for(i = 0; i < 3; i++) {
                    for(j = 0; j < 3; j++) {
                        ch = board[i+l*3][j+k*3];
                        if(ch>='0'&&ch<='9') {
                            if(hash.contains(ch))
                                return false;
                            hash.add(ch);
                        }
                    }
                }                
            }
        }
        return true;
    }
}