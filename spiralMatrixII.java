public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][]res = new int[n][n];
        if(n==0)
            return res;
        int x = 0, y = 0;
        int row = n, col = n;
        int temp = 1;
        while(row > 0 && col > 0) {
            
            if(row==1) {
                for(int i = 0; i < col; i++) {
                    res[x][y++]=temp++;
                }
                break;
            }else if(col==1) {
                for(int i = 0; i < row; i++) {
                    res[x++][y]=temp++;
                }
                break;
            }
            
            for(int i = 0; i < col-1; i++) {
                res[x][y++]=temp++;
            }
            for(int i = 0; i < row-1; i++) {
                res[x++][y]=temp++;
            }
            for(int i = 0; i < col-1; i++) {
                res[x][y--]=temp++;
            }
            for(int i = 0; i < row-1; i++) {
                res[x--][y]=temp++;
            }
            x++;
            y++;
            row = row-2;
            col = col-2;
        }
        return res;
    }
}