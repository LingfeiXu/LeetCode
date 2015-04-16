public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
    	List<String> res = new ArrayList<String>();
        if(s==null||s.length()==0)
            return res;
        ArrayList<String>t[] = new ArrayList[s.length()+1];
        t[0] = new ArrayList<String>();
        
        for(int i = 0; i < s.length(); i++) {
            if(t[i]==null)
                continue;
            for(String a: dict) {
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
                if(s.substring(i,end).equals(a)) {
                    if(t[end]==null)
                    	t[end] = new ArrayList<String>();
                    t[end].add(a);
                }
            }
        }
        if(t[s.length()]==null)
        	return res;
        ArrayList<String> temp = new ArrayList<String>();
        dfs(t, s.length(), res, temp);
        
        return res;
    }
    
	private void dfs(ArrayList<String>[] t, int length,
			List<String> res, ArrayList<String> temp) {
		if(length <= 0) {
			String path = temp.get(temp.size()-1);
			for(int i = temp.size()-2; i>=0; i--) {
				path = path + " " + temp.get(i);
			}
			res.add(path);
			return;
		}
		for(String s: t[length]) {
			temp.add(s);
			dfs(t, length - s.length(), res, temp);
			temp.remove(temp.size()-1);
		}
		return;
	}
}