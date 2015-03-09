public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=0)
            return 0;
        int pre = A[0], length = A.length, index = 0;
        for(int i = 1; i < A.length; i++) {
            int j = i+index;
            if(j>=A.length)
            	return length;
            while(A[j]==pre) {
            	if(j+1>=A.length)
            		return length-1;
                j++;
                index ++;
                length--;
                if(length==1)
                    return length;
            }
            A[i] = A[j];
            pre = A[i];
        }
        return length;
    }
}