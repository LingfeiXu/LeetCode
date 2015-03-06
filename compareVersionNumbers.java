public class Solution {
    public int compareVersion(String version1, String version2) {
        int val1, val2;
        int index1 = 0, index2 = 0;
        while(index1 < version1.length() || index2 < version2.length()) {
            val1 = 0;
            while(index1 < version1.length()) {
                if(version1.charAt(index1) == '.') {
                    index1++;
                    break;
                }
                val1 = val1*10 + (version1.charAt(index1) - '0');
                index1++;
            }
            val2 = 0;
            while(index2 < version2.length()) {
                if(version2.charAt(index2) == '.') {
                    index2++;
                    break;
                }
                val2 = val2*10 + (version2.charAt(index2) - '0');
                index2++;
            }
            if(val1>val2) return 1;
            if(val1<val2) return -1;
        }
        return 0;
    }
}