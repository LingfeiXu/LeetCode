public class Solution {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        tool(n, 0, new int[n], res);
        return res;
    }
    
    public void tool(int n, int currentRow, int[] queenPosition, ArrayList<String[]> res) {
        if(currentRow == n) {
            String[] line = new String[n];
            for(int i=0; i<n; i++) {
                StringBuilder oneline = new StringBuilder();
                for(int j=0; j<n; j++) {
                    if(j==queenPosition[i])
                        oneline.append("Q");
                    else
                        oneline.append(".");
                }
                line[i] = oneline.toString();
            }
            res.add(line);
        }else{
            for(int i=0; i<n; i++) {
                queenPosition[currentRow] = i;
                if(isValid(currentRow,queenPosition))
                    tool(n,currentRow+1,queenPosition,res);
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