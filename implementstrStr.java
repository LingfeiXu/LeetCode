public class Solution {
    public int strStr(String haystack, String needle) {
        int needlen = needle.length(), haylen = haystack.length();
        if(needlen==0||needle==null) 
            return 0;
        if(haystack==null||haylen==0) 
            return -1;
        char need = needle.charAt(0);
        for(int i = 0; i < haylen - needlen +1; i++) {
            if(haystack.charAt(i)==need) {
                if(haystack.substring(i,i+needlen).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}