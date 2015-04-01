public class Solution {
    public int threeSumClosest(int[] num, int target) {
    	int res = 0;
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++) {
            int start = i + 1;
            int end = num.length -1;
            if(i==0)
            	res = num[i] + num[start] + num[end];
            while(start < end) {
                if(target == num[i] + num[start] + num[end])
                    return target;
            	int temp1 = target - num[i] - num[start] - num[end];
            	int temp2 = target - res;
                res = Math.abs(temp1) > Math.abs(temp2)? target - temp2 : target - temp1; 
                if(target>num[start] + num[end]+num[i])
                    start++;
                else
                    end--;
            }

        }
        return res;
    }
}