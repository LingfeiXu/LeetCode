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