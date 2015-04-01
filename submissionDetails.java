public class Solution {
    
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s==null||s.length()==0)
            return res;
        List<String> partition = new ArrayList<String>();
        addPalind(s, 0, partition, res);
        return res;
    }
    
    public static void addPalind(String s, int start, List<String> partition, List<List<String>> res) {
        if(start == s.length()) {
            List<String> temp2 = new ArrayList<String>(partition);
            res.add(temp2);
            return;
        }
        for(int i = start + 1; i <= s.length(); i++) {
            String temp = s.substring(start,i);
            if(isPalind(temp)) {
                partition.add(temp);
                addPalind(s, i, partition, res);
                partition.remove(partition.size()-1);
            }
        }
        
    }
    
    public static boolean isPalind(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right) {
            if(s.charAt(left)!=s.charAt(right))
                 return false;
            left++;
            right--;
        }
        return true;
    }
}