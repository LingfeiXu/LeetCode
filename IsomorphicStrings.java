public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1.containsKey(c1)) {
                if(map1.get(c1)!=c2)
                    return false;
            }
            if(map2.containsKey(c2)) {
                if(map2.get(c2)!=c1)
                    return false;
            }
            map1.put(c1,c2);
            map2.put(c2,c1);
        }
        return true;
    }
}