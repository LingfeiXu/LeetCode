public class Solution {
    public int res;
    public int totalNQueens(int n) {
        res = 0;
        tool(n, 0, new int[n]);
        return res;        
    }
    
    public void tool(int n, int currentRow, int[] queenPosition) {
        if(currentRow == n) {
            res++;
        }else{
            for(int i=0; i<n; i++) {
                queenPosition[currentRow] = i;
                if(isValid(currentRow,queenPosition))
                    tool(n,currentRow+1,queenPosition);
            }
        }
    }
    public boolean isValid(int currentRow, int[] queenPosition) {
        for(int i=0; i<currentRow; i++)  {
            if(queenPosition[i]==queenPosition[currentRow]||Math.abs(queenPosition[i]-queenPosition[currentRow])==currentRow-i)
                return false;
        }
        return true;
    }
}