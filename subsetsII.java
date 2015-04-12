public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if(num==null)
            return null;
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> a: res) {
                temp.add(new ArrayList<Integer>(a));
            }
            for(List<Integer> a: temp) {
            	a.add(num[i]);
            }
            
            List<Integer> single = new ArrayList<Integer>();
            single.add(num[i]);
            temp.add(single);
            for(List<Integer> a:temp) {
            	if(!res.contains(a))
            		res.add(a);
            }
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}