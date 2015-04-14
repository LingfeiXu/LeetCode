public class Solution {
    public void nextPermutation(int[] num) {
        if(num==null)
            return;
        int temp1 = 0, temp2 = -1;
        boolean flag = false;
        for(int i = num.length-1; i > 0; i--) {
            if(num[i]>num[i-1]) {
                temp1 = num[i-1];
                temp2 = i-1;
                flag = true;
                break;
            }
        }
        
        if(flag) {
            for(int i = num.length-1; i >= 0; i--) {
                if(num[i]>temp1) {
                    num[temp2] = num[i];
                    num[i] = temp1;
                    break;
                }
            }
        }
        
        int start = temp2 + 1;
        int end = num.length - 1;
        while(start < end) {
            int temp3 = num[start];
            num[start] = num[end];
            num[end] = temp3;
            start++;
            end--;
        }
        return;
    }
}