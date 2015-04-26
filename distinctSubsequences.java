public class Solution {
    public int numDistinct(String s, String t) {
        if(s==null||t==null)
            return 1;
        int sl = s.length();
        int tl = t.length();
        if(sl<tl)
            return 0;
        if(sl==tl) {
            return s.equals(t)?1:0;
        }
        int [][] dp = new int[tl+1][sl+1];
        for(int i=0; i<=sl; ++i){
            dp[0][i] = 1;
        }
        for(int i=1; i<=tl; ++i){
            for(int j=1; j<=sl; ++j){
                if(t.charAt(i-1) != s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }   
        }
        return dp[tl][sl];
    }
}