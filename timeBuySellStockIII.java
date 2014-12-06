public class Solution {
    public int maxProfit(int[] prices) {
        int[] fir = new int[prices.length];
        int[] sec = new int[prices.length];
        if(prices==null||prices.length==0)
        	return 0;
        int min1 = prices[0],max2 = prices[prices.length-1];
        fir[0] = 0; sec[prices.length-1] = 0;
        for(int i=1; i<prices.length; i++) {
            fir[i] = Math.max(prices[i]-min1,fir[i-1]);
            min1 = Math.min(prices[i],min1);
        }
        for(int i=prices.length-2; i>=0; i--) {
            sec[i] = Math.max(max2-prices[i],sec[i+1]);
            max2 = Math.max(prices[i],max2);
        }
        int sum = 0;
        for(int i=0; i<prices.length; i++){
            sum = Math.max(fir[i]+sec[i],sum);
        }
        return sum;
    }
}