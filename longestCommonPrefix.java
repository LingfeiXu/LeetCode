public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String res = strs[0];
        for(String s: strs) {
            if(s.equals(""))
                return "";
            String temp = null;
            int len = s.length()>res.length()?res.length():s.length();
            for(int i = 0; i < len; ++i) {
                char ch = s.charAt(i);
                if(ch==res.charAt(i)) {
                	if(i == 0)
                		temp =  Character.toString(ch);
                	else
                		temp =  temp + Character.toString(ch);
                }     
                else
                    break;
            }
            if(!res.equals(temp))
                res = temp;
            if(res==null)
            	return "";
        }
        return res;
    }
}