public class Solution {
    public List<String> res;
    
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        if(s==null||s.length()<4)
            return res;
        ipAddress(s, 0, 0, "");
        return res;
    }
    
    public void ipAddress(String s, int start, int num, String cur) {
    	String temp = cur;
    	if(start>s.length()-1)
    		return;
        int temp1 = Integer.parseInt("" + s.charAt(start));
        if(temp1>=0&&temp1<=255) {
            if(num+1==4){
                if(start==s.length()-1) {
                	cur = cur + temp1;
                	res.add(cur);
                    return;
                }
            }
            if(num+1<4) {
            	cur = cur + temp1 + ".";
            	ipAddress(s, start + 1, num + 1,cur);
            }
        }
        if(s.charAt(start)!='0') {
        	cur = temp;
        	if(start+1>s.length()-1)
        		return;
            int temp2 = Integer.parseInt("" + s.charAt(start)+s.charAt(start+1));
            if(temp2>=0&&temp2<=255) {
                if(num+1==4){
                    if(start==s.length()-2) {
                    	cur = cur + temp2;
                    	res.add(cur);
                        return;
                    }
                }
                if(num+1<4) {
                	cur = cur + temp2 + ".";
                	ipAddress(s, start + 2, num + 1,cur);
                }
            }
            cur = temp;
            if(start+2>s.length()-1)
        		return;
            int temp3 = Integer.parseInt("" + s.charAt(start)+s.charAt(start+1)+s.charAt(start+2));
            if(temp3>=0&&temp3<=255) {
                if(num+1==4){
                    if(start==s.length()-3) {
                    	cur = cur + temp3;
                    	res.add(cur);
                        return;
                    }
                }
                if(num+1<4) {
                	cur = cur + temp3 + ".";
                	ipAddress(s, start + 3, num + 1,cur);
                }
            }
        }
        return;
    }
}