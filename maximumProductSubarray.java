public class Solution {
    public int maxProduct(int[] A) {
        if(A==null||A.length==0)
            return 0;
        if(A.length==1)
            return A[0];
        int res = A[0], maxLocal = A[0], minLocal = A[0], temp = A[0];
        for(int i = 1; i < A.length; i++) {
            temp = maxLocal;
            maxLocal = Math.max(Math.max(A[i],A[i]*maxLocal),A[i]*minLocal);
            minLocal = Math.min(Math.min(A[i],A[i]*temp),A[i]*minLocal);
            res = Math.max(maxLocal, res);
        }
        return res;
    }
}