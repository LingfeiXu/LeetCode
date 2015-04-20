public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null||num.length==0)
            return res;
        return mute(num, num.length, res);
    }
    
    public List<List<Integer>> mute(int[] num, int len, List<List<Integer>> res) {
        if(len == 1) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(num[0]);
            res.add(cur);
            return res;
        }
        res = mute(num, len-1, res);
        int insert = num[len-1];
        int size = res.size();
        for(int i = 0; i < size; i++) {
            List<Integer> cur = res.get(0);
            res.remove(cur);
            for(int j = 0; j < cur.size()+1; j++) {
                List<Integer> temp = new ArrayList<Integer>(cur);
                temp.add(j, insert);
                if(!res.contains(temp))
                    res.add(temp);
            }
        }
        return res;
    }
}