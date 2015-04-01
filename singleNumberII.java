public class Solution {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < A.length; i++) {
            two = two|(A[i]&one);
            one = one^A[i];
            three = one&two;
            one = (~three)&one;
            two = (~three)&two;
        }
        return one;
    }
}