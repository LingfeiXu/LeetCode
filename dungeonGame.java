public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)
            return 0;
        int row = dungeon.length-1;
        int col = dungeon[0].length-1;
        int curRow = 0, curCol = 0;
        int[][] cost = new int[row+1][col+1];
        while(curRow <= row) {
        	curCol = 0;
            while(curCol <= col) {
                if(curRow==0&&curCol==0) {
                    cost[curRow][curCol] = dungeon[0][0];
                } else if(curRow==0&&curCol!=0) {
                	cost[curRow][curCol] = cost[curRow][curCol-1] + dungeon[curRow][curCol];
                } else if (curRow!=0&&curCol==0) {
                	cost[curRow][curCol] = cost[curRow-1][curCol] + dungeon[curRow][curCol];
                } else {
                	cost[curRow][curCol] = Math.max(cost[curRow][curCol-1],cost[curRow-1][curCol])+dungeon[curRow][curCol];
                }
                curCol++;
            }
            curRow++;
        }
        int[][] health = new int[row+1][col+1];
        curRow = 0; curCol = 0;
        while(curRow <= row) {
        	curCol = 0;
            while(curCol <= col) {
                if(curRow==0&&curCol==0) {
                    health[curRow][curCol] = dungeon[0][0];
                } else if(curRow==0&&curCol!=0) {
                    health[curRow][curCol] = health[curRow][curCol-1];
                    if(cost[curRow][curCol]<0)
                        health[curRow][curCol] = Math.min(cost[curRow][curCol],health[curRow][curCol]);
                } else if (curRow!=0&&curCol==0) {
                    health[curRow][curCol] = health[curRow-1][curCol];
                    if(cost[curRow][curCol]<0)
                        health[curRow][curCol] = Math.min(cost[curRow][curCol],health[curRow][curCol]);
                } else {
            		int temp = health[curRow-1][curCol];	
                	if(dungeon[curRow][curCol]>=0||cost[curRow-1][curCol]>=-dungeon[curRow][curCol])
                		temp = health[curRow-1][curCol];
                	else
                		temp = Math.min(temp, cost[curRow-1][curCol]+dungeon[curRow][curCol]);
            		int temp2 = health[curRow][curCol-1];	
                	if(dungeon[curRow][curCol]>=0||cost[curRow][curCol-1]>=-dungeon[curRow][curCol])
                		temp2 = health[curRow][curCol-1];
                	else
                		temp2 = Math.min(temp2, cost[curRow][curCol-1]+dungeon[curRow][curCol]);
                	health[curRow][curCol] = Math.max(temp, temp2);
                }
                curCol++;
            }
            curRow++;
        }
        
        return health[row][col]>=0?1:Math.abs(health[row][col]-1);
    }
}