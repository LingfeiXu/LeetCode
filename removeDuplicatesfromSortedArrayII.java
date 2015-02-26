public class Solution {
    public int removeDuplicates(int[] A) {
        int k = 0;
        int count = 1;
        if(A.length<3)
            return A.length;
        for(int i =0; i < A.length; i++) {
            if(i>0 && A[i]==A[i-1])
                count++;
            else
                count = 1;
            if(count<=2){
                A[k] = A[i];
                k++;
            }
        }
        return k;
    }
}