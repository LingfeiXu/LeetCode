public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null||grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}};
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j]&&grid[i][j]=='1') {
                    res++;
                    stack.push(i*col+j);
                    while(!stack.empty()) {
                        int pos = stack.pop();
                        int curRow = pos/col;
                        int curCol = pos%col;
                        if(visited[curRow][curCol]) {
                            continue;
                        }
                        visited[curRow][curCol] = true;
                        for(int k = 0; k < 4; k++) {
                            int x = curRow + direct[k][0];
                            int y = curCol + direct[k][1];
                            if(x>=0&&y>=0&&x<row&&y<col&&grid[x][y]=='1')
                                stack.push(x*col + y);
                        }
                    }
                }
            }
        }
        return res;
    }
}