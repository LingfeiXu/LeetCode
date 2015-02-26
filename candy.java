public class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        int[] rate =new int[ratings.length];
        rate[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1])
                rate[i] = rate[i-1]+1;
            else
                rate[i] = 1;
        }
        res = res + rate[ratings.length-1];
        for(int i = ratings.length - 1; i>0; i--) {
            if(ratings[i-1]>ratings[i]&&rate[i-1]<=rate[i]) {
                rate[i-1] = rate[i]+1;
            }
            res = res + rate[i-1];
        }
        return res;
    }
}