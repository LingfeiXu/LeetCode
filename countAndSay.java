public class Solution {
    public String countAndSay(int n) {
        if(n <= 0)
            return "";
        int i = 1;
        String pre = "1";
        String res = pre;
        while(i < n) {
            char temp = 'a';
            char preTemp = 'a';
            int count = 0;
            res = "";
            for(int j = 0; j < pre.length(); j++) {
                temp = pre.charAt(j);
                if(temp == preTemp||j==0)
                    count++;
                else{
                    res = res + count;
                    res = res + preTemp;
                    count = 1;
                }
                preTemp = temp;
                if(j == pre.length() - 1) {
                	res = res + count;
                	res = res + temp;
                }
            }
            pre = res;
            i++;
        }
        return res;
    }
}