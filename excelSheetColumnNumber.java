public class Solution {
    public int titleToNumber(String s) {
        if(s==null||s.length()==0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<26; i++) {
            map.put((char)('A'+i),1+i);
        }
        int len = s.length();
        int result = 0;
        for(int i = len-1; i >= 0; i--) {
            char temp = s.charAt(len-i-1);
            result += map.get(temp)*(int)Math.pow(26,i);
        }
        return result;
    }
}