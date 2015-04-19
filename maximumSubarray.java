public class Solution {
    public int max = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        return max(nums, 0, nums.length-1);
    }
    
    public int max(int[] nums, int left, int right) {
        if(left>right)
            return Integer.MIN_VALUE;
        int mid = (left + right)/2;
        int maxLeft = max(nums, left, mid - 1);
        int maxRight = max(nums, mid + 1, right);
        max = Math.max(maxLeft, max);
        max = Math.max(maxRight,max);
        int curMax = 0;
        int sum = 0;
        for(int i = mid-1; i >= left; i--) {
            sum = sum + nums[i];
            curMax = Math.max(curMax, sum);
        }
        int curMax2 = 0;
        sum = 0;
        for(int i = mid+1; i <= right; i++) {
            sum = sum + nums[i];
            curMax2 = Math.max(curMax2, sum);
        }
        max = Math.max(max, curMax + curMax2 + nums[mid]);
        return max;
    }
}