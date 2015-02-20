public class Solution {
    public int search(int[] A, int target) {
        int len = A.length;
        int right = len-1;
        int left = 0;
        while(left<=right) {
            int mid = (right+left)/2;
            if(A[mid]==target)
                return mid;            
            if (A[mid]>=A[left]) {
                if(A[left]<=target && target<A[mid])
                    right = mid-1;
                else
                    left = mid+1;
            } else {
                if(A[mid]<target && target<=A[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
}