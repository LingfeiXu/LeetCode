public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if(strs==null||strs.length==0)
            return res;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++) {
            String s = seq(strs[i]);
            if(hash.containsKey(s)) {
                int temp = hash.get(s);
                if(visited[temp]) {
                    res.add(strs[temp]);
                    visited[temp] = false;
                }
                res.add(strs[i]);
                continue;
            }
            if(s==null||s.length()==0) {
                hash.put("",i);
            } else { 
                hash.put(s,i);
            }
            visited[i] = true;
        }
        return res;
    }
    
    public String seq(String s) {
        String res = "";
        while(s.length()!=0) {
            char l = s.charAt(0);
            int k = 0;
            for(int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                k = temp < l? i:k;
                l = temp < l? temp:l;
            }
            res = res + l;
            StringBuffer sb = new StringBuffer(s);
            sb.delete(k,k+1);
            s = sb.toString();
        }
        return res;
    }
}