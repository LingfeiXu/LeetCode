public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)
            return;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        for(int i = 0; i < row; i++) {
            if(matrix[i][0]==0)
                rowFlag = true;
        }
        for(int i = 0; i < column; i++) {
            if(matrix[0][i]==0)
                colFlag = true;
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j< column; j++) {
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        if(rowFlag) {
            for(int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if(colFlag) {
            for(int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }
        return;
        
    }
}