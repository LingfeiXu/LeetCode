public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A==null||A.length==0)
            return 0;
        int start = 0;
        int end = A.length;
        while(start <= end) {
            int mid = (start + end)/2;
            if(A[mid]==target) {
                return mid;
            } else if(A[mid]>target) {
                if(mid==0||A[mid-1]<target)
                    return mid;
                end = mid - 1;
            } else {
                if(mid==A.length-1||A[mid+1]>target)
                    return mid+1;
                start = mid + 1;
            }
        }
        return 0;
    }
}