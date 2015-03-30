public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        int len = Math.max(m,n);
        String res = "";
        for(int i =0; i < len; i++) {
            int p = 0, q = 0;
            if(i < m)
                p = a.charAt(m-i-1) - '0';
            else
                p = 0;
            if(i < n)
                q = b.charAt(n-i-1) - '0';
            else
                q = 0;
            int temp = p + q + carry;
            carry = temp/2;
            res = temp%2 + res;
        }
        return (carry==0)?res:"1"+res;
    }
}