public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums==null||nums.length==0)
            return res;
        int start = nums[0];
        int cur = nums[0];
        String temp = "";
        if(nums.length==1) {
            temp += start; 
            res.add(temp);
            return res;
        }
        for(int i = 1; i < nums.length; i++) {
            if(nums[i]==cur+1){
                cur = nums[i];
            } else {
                if(cur==start) {
                    temp += start;
                    res.add(temp);
                    temp = "";
                }
                else{
                    temp += start + "->" + cur;
                    res.add(temp);
                    temp = "";
                }
                cur = nums[i];
                start = nums[i];
            }
        }
        if(cur!=start) {
            temp += start + "->" + cur;
        } else {
            temp += start;
        }
        res.add(temp);
        return res;
    }
}