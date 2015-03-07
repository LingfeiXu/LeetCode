public class Solution {
    public int reverse(int x) {
        int minus = 0;
        if(x < 0) {
            x = - x;
            minus = 1;
        }
        if(x<0)
        	return 0;
        int origin = x;
        int div = 1, i = 1;
        while(x/10>0) {
            x = x/10;
            div = div*10;
            i++;
        }
        x = origin;
        if(i==1)
            return x;
        int k = 0;
        int[] left;
        int[] right;
        if(i%2==0) {
            left = new int[i/2];
            right = new int[i/2];
            k = i/2-1;
        } else {
            left = new int[(i-1)/2];
            right = new int[(i-1)/2];
            k = (i-1)/2-1;
        }
        int temp = div;
        int j = 0, mid = 0;
        while(k>=0) {
            left[j] = x%10;
            right[k] = x/div;
            x = (x%div)/10;
            div = div/100;
            j++;
            if(k==0)
                mid = x;
            k--;
        }
        j--;
        int res = 0, l = j;
        j = 0;
        while(j <= l) {
        	int temp2 = left[j]*temp;
        	if((left[j]!=0&&temp2/left[j]!=temp)||(temp!=0&&temp2/temp!=left[j]))
        		return 0;
            res = res + temp2;
            temp = temp/10;
            j++;
        }
        if(i%2!=0) {
            res = res + mid*temp;
            temp = temp/10;
        }
        j=0;
        while(j <= l) {
            res = res + right[j]*temp;
            temp = temp/10;
            j++;
        }
        if(res<0)
        	return 0;
        if(minus==1)
            res = -res;
        return res;
    }
}