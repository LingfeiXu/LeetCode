public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null||num.length==0)
            return null;
        List<Integer> cur = new ArrayList<Integer>();
        dfs(num, target, cur, res, 0);
        return res;
    }
    
    public void dfs(int[] num, int target, List<Integer> cur, List<List<Integer>> res, int pre) {
        if(target == 0) {
        	List<Integer> temp2 = new ArrayList<Integer>(cur);
        	if(!res.contains(temp2)) {
        		res.add(temp2);
        	}
            return;
        }
        for(int i = 0; i < num.length; i++) {
            int temp = num[i];
            if(temp <= target&&temp>=pre) {
                cur.add(temp);
                num[i] = target+1;
                dfs(num, target-temp, cur, res, temp);
                num[i] = temp;
                cur.remove(new Integer(temp));
            }
        }
        return;
    }
}