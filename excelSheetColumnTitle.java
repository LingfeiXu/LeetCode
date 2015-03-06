public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n>0) {
            int i = n%26;
            n = n/26;
            if(i==0) {
                res.insert(0,(char)('Z'));
                n--;
            }
            else
                res.insert(0,(char)('A'+i-1));
        }
        return res.toString();
    }
}