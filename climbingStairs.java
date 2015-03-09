public class Solution {
    public int climbStairs(int n) {
        if(n == 0)
            return 0;
        int[] res = new int[3];
        if(n==1)
            return 1;
        res[0] = 1;
        res[1] = 2;
        for(int i = 2; i < n; i++) {
            res[i%3] = res[(i-1)%3] + res[(i-2)%3];
        }
        return res[(n-1)%3];
    }
}