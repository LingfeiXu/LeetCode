public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        while( m > 0 && n > 0) {
            if(B[n-1]>A[m-1]) {
                A[m+n-1] = B[n-1];
                n--;
            } else {
                A[m+n-1] = A[m-1];
                m--;
            }
        }
        while(n > 0) {
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}