public class Solution {
    public int findPeakElement(int[] num) {
        if(num.length == 1)
            return 0;
        return findPeak(num, num.length/2, 0, num.length);
    }

	public int findPeak(int[] num, int mid, int start, int end) {
	    if(mid == 0 && num[mid]>num[mid+1])
	        return mid;
	    if(mid == num.length - 1 && num[mid]>num[mid-1])
	        return mid;
	    if(num[mid]>num[mid-1]&&num[mid]>num[mid+1])
	        return mid;
	    if(num[mid]>num[mid-1]) {
	    	start = mid;
	        mid = (start + end)/2;
	        return findPeak(num, mid, start, end);
	    } else {
	        end = mid;
	        mid = (start + end)/2;
	        return findPeak(num, mid, start, end);
	    }
	}
}