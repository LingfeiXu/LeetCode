public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int sum[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i==0&&j==0) {
                    sum[i][j] = grid[0][0];
                } else if(i==0&&j!=0) {
                    sum[i][j] = sum[i][j-1] + grid[i][j];
                } else if(j==0&&i!=0) {
                    sum[i][j] = sum[i-1][j] + grid[i][j];
                } else {
                    sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
                }
            }
        }
        return sum[m-1][n-1];
    }
}