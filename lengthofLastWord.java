public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length() == 0)
            return 0;
        char temp = 'a';
        int count = 0, res = 0;
        for(int i = s.length() - 1; i >= 0; i--) 
        {
            temp = s.charAt(i);
            temp = s.charAt(i);
            if(temp == ' ')
                count = 0;
            else {
                count++;
                res = count;
            }
            if(temp == ' ' && res!=0)
            	return res;
        }
        return res;
    }
}