public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if( (m+n)%2 != 0)
            return median(nums1, nums2, (m+n)/2, 0, m-1, 0, n-1);
        else
            return (median(nums1, nums2, (m+n)/2, 0, m-1, 0, n-1) + median(nums1, nums2, (m+n)/2 -1, 0, m-1, 0, n-1))*0.5;
    }
    
    public int median(int a[], int[]b, int k, int a1, int a2, int b1, int b2) {
        int alen = a2-a1+1;
        int blen = b2-b1+1;
        if(alen==0)
            return b[b1+k];
        if(blen==0)
            return a[a1+k];
        if(k==0)
            return a[a1] < b[b1]? a[a1]:b[b1];
        int aMid = alen*k/(alen+blen);
        int bMid = k - aMid - 1;
        aMid = aMid + a1;
        bMid = bMid + b1;
        
        if(a[aMid] > b[bMid]) {
            k = k - (bMid - b1 + 1);
            a2 = aMid;
            b1 = bMid + 1;
        } else {
            k = k - (aMid - a1 + 1);
            b2 = bMid;
            a1 = aMid + 1;
        }
        return median(a, b, k, a1, a2, b1, b2);
            
    }
}