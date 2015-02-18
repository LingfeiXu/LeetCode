public class Solution {
    public String convert(String s, int nRows) {
        String res = new String();
        StringBuilder converter = new StringBuilder();
        int lineNum = 2*nRows-2;
        if (nRows == 1)
            return s;
        for(int i=0; i<nRows; i++) {
            if (i==0||i==nRows-1) {
                for (int j = i; j<s.length(); j+=lineNum) {
                    converter.append(s.charAt(j));
                }
            } else {
                int j = i;
                int lineNum1 = 2*nRows-2-2*i;
                int lineNum2 = 2*i;
                boolean flag = true;
                while (j<s.length()) {
                    converter.append(s.charAt(j));
                    if(flag) {
                        j += lineNum1;
                    } else {
                        j += lineNum2;
                    }
                    flag = !flag;
                }
            }
        }
        res = converter.toString();
        return res;
    }
}