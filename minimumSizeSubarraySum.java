public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while(start < nums.length) {
            while(sum < s&&start < nums.length){
                sum += nums[start++];
            }
            if(sum < s)
                break;
            while(sum >= s && end < start) {
                sum = sum - nums[end++];
            }
            minLen = Math.min(minLen, start - end + 1);
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}