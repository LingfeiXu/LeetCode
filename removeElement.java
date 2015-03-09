public class Solution {
    public int removeElement(int[] A, int elem) {
        int length = 0;
        for(int i: A) {
            if(i!=elem) {
                A[length] = i;
                length++;
            }
        }
        return length;
    }
}