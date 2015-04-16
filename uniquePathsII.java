public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return 0;
            
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m<=0||n<=0)
            return 0;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
            return 0;
            
        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i]!=1)
                temp[i] = 1;
            else {
            	for(int j = i; j < n; j++)
            		temp[j] = 0;
            	break;
            }
        }
        boolean flag = true;
        for(int i = 1; i < m; i++) {
        	if(flag) {
	        	if(obstacleGrid[i][0]!=1) {
	        		temp[0] = temp[0];
	        	} else {
	        		temp[0] = 0;
	        		flag = false;
	        	}
        	}
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]!=1)
                    temp[j] = temp[j - 1] + temp[j];
                else
                    temp[j] = 0;
            }
        }
        return temp[n-1];
    }
}