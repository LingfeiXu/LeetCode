public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        if(A==null)
            return res;
        int start = 0;
        int end = A.length-1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(A[mid] == target) {
                int left = mid;
                int right = mid;
                while(left>0&&A[left]==A[left-1]) {
                    left--;
                }
                while(right<A.length-1&&A[right]==A[right+1]) {
                    right++;
                }
                int[] res1 = {left,right};
                return res1;
            } else if(A[mid] > target) {
                end = mid-1;
            } else if(A[mid] < target) {
                start = mid+1;
            }
        }
        return res;
    }
}