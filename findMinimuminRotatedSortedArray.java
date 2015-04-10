public class Solution {
    public int findMin(int[] num) {
        if(num==null||num.length==0)
            return 0;
        int res = fMin(num, 0, num.length-1);
        return res;
    }
    
    public int fMin(int[] num, int start, int end) {
        int mid = (start+end)/2;
        if(start == end)
            return num[start];
        if(start == end - 1)
        	return Math.min(num[start], num[end]);
        if(num[mid] > num[start]&&num[mid] > num[end])
            return fMin(num, mid+1, end);
        else
            return fMin(num, start, mid);
    }
}