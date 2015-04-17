public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0)
            return null;
        List<Integer> cur = new ArrayList<Integer>();
        dfs(candidates, target, cur, res, 0);
        return res;
    }
    
    public void dfs(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res, int pre) {
        if(target == 0) {
        	List<Integer> temp2 = new ArrayList<Integer>(cur);
            res.add(temp2);
            return;
        }
        for(int temp: candidates) {
            if(temp <= target&&temp>=pre) {
                cur.add(temp);
                dfs(candidates, target-temp, cur, res, temp);
                cur.remove(new Integer(temp));
            }
        }
        return;
    }
}