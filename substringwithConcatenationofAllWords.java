public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        if(L.length==0||L==null||S.length()==0||S==null)
            return null;
        List<Integer> res = new ArrayList<Integer>();
        int n = L.length, m = L[0].length(), l = S.length();
        
        Map<String,Integer>covered = new HashMap<String,Integer>();
        for(int i=0; i<n; i++) {
            if(covered.containsKey(L[i]))
                covered.put(L[i],covered.get(L[i])+1);
            else
                covered.put(L[i],1);
        }
        int i = 0;
        while(l-i>=m*n) {
            Map<String,Integer> tempMap = new HashMap<String,Integer>(covered);
            for(int j=0; j<n; j++) {
                String tempStr = S.substring(i+j*(m),i+(j+1)*m);
                if(tempMap.containsKey(tempStr)) {
                    if(tempMap.get(tempStr)-1==0)
                        tempMap.remove(tempStr);
                    else
                        tempMap.put(tempStr,tempMap.get(tempStr)-1);
                } else
                    break;
            }
            if(tempMap.size()==0)
                res.add(i);
            i++;
        }
        return res;
    }
} 