public class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length)
            k = k%nums.length;
        if(k==nums.length)
            return;
        int[] numk = new int[k];
        int[] numr = new int[nums.length-k];
        int l = 0;
        for(int i = nums.length - k; i < nums.length; i++) {
            numk[l] = nums[i];
            l++;
        }
        l = 0;
        for(int i = 0; i < nums.length - k; i++) {
            numr[l] = nums[i];
            l++;
        }
        for(int i = 0; i < k; i++) {
            nums[i] = numk[i];
        }
        l = 0;
        for(int i = k; i < nums.length; i++) {
            nums[i] = numr[l];
            l++;
        }
    }
}