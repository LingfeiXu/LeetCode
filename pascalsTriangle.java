public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows<1)
            return res;
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        for(int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j)+pre.get(j-1));
            }
            cur.add(1);
            res.add(cur);
            pre = new ArrayList<Integer>(cur);
        }
        return res;
    }
}