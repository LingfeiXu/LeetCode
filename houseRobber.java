public class Solution {
    public int rob(int[] num) {
        if(num==null||num.length==0)
            return 0;
        if(num.length==1)
            return num[0];
        int[] curMax = new int[num.length];
        curMax[0] = num[0];
        curMax[1] = Math.max(num[1],num[0]);
        
        for(int i = 2; i < num.length; i++) {
            curMax[i] = Math.max(num[i]+curMax[i-2], curMax[i-1]);
        }
        return curMax[num.length-1];
    }
}