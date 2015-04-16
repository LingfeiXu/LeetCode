public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)
            return 1;
        if(m<=0||n<=0)
            return 0;
        int[] temp = new int[n];
        int[] temp2 = new int[n];
        for(int i = 0; i < n; i++) {
            temp[i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                temp[j] = temp[j - 1] + temp[j];
            }
        }
        return temp[n-1];
    }
}