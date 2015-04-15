public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null||matrix.length==0)
            return result;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int x = 0, y = 0;
        
        while(row > 0 && col > 0) {
            
            if(row==1) {
                for(int i = 0; i < col; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(col==1) {
                for(int i = 0; i < row; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }
            
            for(int i = 0; i < col-1; i++) {
                result.add(matrix[x][y++]);
            }
            for(int i = 0; i < row-1; i++) {
                result.add(matrix[x++][y]);
            }
            for(int i = 0; i < col-1; i++) {
                result.add(matrix[x][y--]);
            }
            for(int i = 0; i < row-1; i++) {
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            row = row-2;
            col = col-2;
        }
        return result;
    }
}