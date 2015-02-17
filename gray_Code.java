public class Solution {
    public List<Integer> grayCode(int n) {
        if(n==0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        ArrayList<Integer> pre = new ArrayList<Integer>(grayCode(n-1));
        int first = 1 << (n-1);
        ArrayList<Integer> res = new ArrayList<Integer>(pre);
        for(int i=pre.size()-1; i>=0; i--) {
            res.add(first+pre.get(i));
        }
        return res;
    }
}