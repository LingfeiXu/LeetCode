public class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int start = 0;
        int end = height.length-1;
        int res = Math.min(height[start], height[end])*(end-start);
        while(start < end) {
            int temp = Math.min(height[start], height[end])*(end-start);
            res = Math.max(temp,res);
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        return res;
    }
}