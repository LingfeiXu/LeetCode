public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        int res0 = valid(s.charAt(0));
        if(s.length()==1)
            return res0;
        int res1 = valid(s.charAt(0), s.charAt(1)) + valid(s.charAt(1))*res0;
        
        if(s.length()==2)
        	return res1;
        
        int res2 = 0;
        for(int i = 2; i < s.length(); i++) {
            res2 = valid(s.charAt(i-1),s.charAt(i))*res0 + valid(s.charAt(i))*res1;
            res0 = res1;
            res1 = res2;
        }
        return res2;
            
    }
    
    public int valid(int i1, int i2) {
        if(i1=='1'||(i1=='2'&&i2<='6')) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int valid(char i) {
    	if(i!='0')
    		return 1;
    	else
    		return 0;
    }
    
}