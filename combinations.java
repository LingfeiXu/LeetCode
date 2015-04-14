public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k<=0)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        if(k==1) {
            for(int i = 1; i <= n; i++) {
            	cur = new ArrayList<Integer>();
            	cur.add(i);
                res.add(cur);
            }
            return res;
        }
        List<List<Integer>> temp = null;
        if(k > 1) {
            if(k > n)
                k = n;
            temp = combine(n, k - 1);
            int i = temp.size();
            for(int j = 0; j < i; j++) {
                List<Integer> temp2 = new ArrayList(temp.get(j));
                int temp3 = temp2.get(temp2.size()-1)+1;
                while(temp3<=n) {
                	temp2 = new ArrayList(temp.get(j));
                    temp2.add(temp3);
                    temp.add(temp2);
                    temp3++;
                }
            }
            for(int j = 0; j < i; j++) {
                temp.remove(0);
            }
        }
        return temp;
    }
}