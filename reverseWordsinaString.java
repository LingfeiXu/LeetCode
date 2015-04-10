/*
public class Solution {
    public String reverseWords(String s) {
        String res = "";
        if(s==null||s.length()==0)
            return res;
        String regex = " ";
        String[] temp = s.split(regex);
        int temp2 = 1;
        for(int i = temp.length - 1; i >= 0; i--) {
            if(temp[i].length()>=1) {
                if(temp2!=1)
                    res = res + " ";
                res = res + temp[i];
                temp2++;
            }
        }
        return res;
    }
}
*/
public class Solution {
    public static String reverseWords(String s) {
        if(s.isEmpty() || s.length() == 0)   return s;
         
        StringBuffer res = new StringBuffer();
         
        int t, h;
        for(int i = s.length() - 1; i >= 0; i--) {
            while(i >= 0 && s.charAt(i) == ' ') i--;
             
            // set tail pointer
            if(i < 0) break;
            t = i;
            h = t;
             
            // set head pointer
            while(i >= 0 && s.charAt(i) != ' ') { h = i; i--; }
             
            // append this word (append a space if find more than two words)
            if(h <= t && res.length() > 0) res.append(' ');
            for(int j = h; j <= t; j++) {
                res.append(s.charAt(j));
            }
        }
         
        return res.toString();
    }
}