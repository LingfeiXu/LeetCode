public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recursive(n,0,0,"",res);
        return res;
    }
    
    public void recursive(int n, int left, int right, String s, List<String> res) {
        if(left<right) {
            return;
        }
        
        if(left==n&&right==n) {
            res.add(s);
            return;
        }
        
        if(left==n) {
            recursive(n, left, right+1, s+")", res);
            return;
        }
        recursive(n, left+1, right, s+"(", res);
        recursive(n, left, right+1, s+")", res);
    }
}