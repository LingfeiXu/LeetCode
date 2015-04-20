public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0)
            return "0";
        if(num1.equals("0")||num2.equals("0"))
        	return "0";
        String[] mid = new String[num2.length()];
        int k = 1;
        for(int i = num2.length()-1; i >=0 ; i--) {
            String temp2 = "" + num2.charAt(i);
            int sec = Integer.parseInt(temp2);
            StringBuffer sb = new StringBuffer("");
            int left = 0;
            for(int j = num1.length()-1; j >= 0; j--) {
                String temp1 = "" + num1.charAt(j);
                int fir = Integer.parseInt(temp1);
                int res = sec * fir + left;
                left = res/10;
                int right = res - left*10;
                sb.insert(0, right+"");
                if(left!=0&&j==0) {
                    sb.insert(0, left + "");
                }
            }
            mid[i] = sb.toString();
            int temp = k;
            while(temp > 1) {
                mid[i] = mid[i] + "0";
                temp--;
            }
            k++;
        }
        int left = 0, res = 0, right = 0;
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < mid[0].length() ; i++) {
            res = 0;
            for(int j = 0; j < mid.length; j++) {
	        	if(mid[j].length()>i) {
	                int temp = Integer.parseInt(mid[j].charAt(mid[j].length() -1 - i) + "");
	                res = res + temp;
	        	}
            }
            res = res + left;
            left = res/10;
            right = res - left*10;
            sb.insert(0,right+"");
            if(left!=0&&i==mid[0].length()-1) {
                sb.insert(0,left+"");
            }
        }
        String result = sb.toString();
        return result;
    }
}