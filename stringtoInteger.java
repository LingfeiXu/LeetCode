public class Solution {
    public int atoi(String str) {
    	str = str.trim();
        int len = str.length();
        int res = 0;
        int div = 1;
        boolean isValid = false;
        boolean exceedp = false, exceedn = false, exceed = false;
        boolean isNegative = false, isPositive = true;
        int round = 1;
        for(int i = len - 1; i>=0; i--) {
            String s = str.substring(i,i+1);
            if(s.compareTo("0")>=0&&s.compareTo("9")<=0) {
                int temp = div;
                if(round == 1)
                	div = 1;
                else {
	                div = div*10;
	                if(div/10!=temp) {
	                	exceed = true;
	                	continue;
	                }
                }
                round++;
                res = res + Integer.parseInt(s)*div;
                isValid = true;
                
            }else if(s.equals("+")||s.equals("-")) {
            	if(res<0) {
            		if(s.equals("+"))
            			exceedp = true;
            		else
            			exceedn = true;
            	}
                if(s.equals("-")) {
                	res = -res;
                	isNegative = true;
                	isPositive = false;
                }
            	isValid = !isValid;
            	if(isValid)
            		return 0;
            }else {
            	isValid = false;
            	res = 0;
            	div = 1;
            	exceedp = false;
            	exceedn = false;
            	isNegative = false;
            	isPositive = true;
            	round = 1;
            	exceed = false;
            }
        }
        if(exceedp||(isPositive&&exceed))
        	return Integer.MAX_VALUE;
        if(exceedn||(isNegative&&exceed))
        	return Integer.MIN_VALUE;
        return res;
    }
}