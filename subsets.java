public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if(S==null)
            return null;
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < S.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> a: res) {
                temp.add(new ArrayList<Integer>(a));
            }
            for(List<Integer> a: temp) {
            	a.add(S[i]);
            }
            
            List<Integer> single = new ArrayList<Integer>();
            single.add(S[i]);
            temp.add(single);
            res.addAll(temp);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}