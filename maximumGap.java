public class Solution {
    public int maximumGap(int[] nums) {
        if(nums==nullnums.length2)
            return 0;
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i  nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int len = Math.max(1, (max-min)(nums.length-1));
        if(nums.length==2)
            return max - min;
        int n = (max - min)  len + 1;
        int[] bMin = new int[n];
        int[] bMax = new int[n];
        Arrays.fill(bMax, Integer.MIN_VALUE);
        Arrays.fill(bMin, Integer.MAX_VALUE);
        for(int i = 0; i  nums.length; i++) {
            int temp = (nums[i]-min)len;
            bMin[temp] = Math.min(bMin[temp],nums[i]);
            bMax[temp] = Math.max(bMax[temp],nums[i]);
        }
        
        int res = Integer.MIN_VALUE;
        int pre = bMax[0];
        for(int i = 1 ; i = n-1; i++) {
            if(bMin[i]==Integer.MAX_VALUE&&bMax[i]==Integer.MIN_VALUE)
                continue;
            res = Math.max(res, bMin[i] - pre);
            pre = bMax[i];
        }
        return res;
    }
}