public class Solution {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] palindrome = new boolean[length][length];
        int[] cut = new int[length+1];
        for(int i=0; i<length; i++) {
        	cut[i] = length-i;
        }
        if (s == null || length == 0)
			return 0;
        for(int i=length-1; i>=0; i--) {
        	for(int j=i; j<length; j++) {
        		if ((s.charAt(i) == s.charAt(j) && (j-i<2))
						|| (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1])) {
        			palindrome[i][j] = true;
        			cut[i] = Math.min(cut[i], cut[j+1]+1);
        		}

        	}      	
        }
        return cut[0]-1;
    }
    
    public static void main(String[] args) {
    	Solution sl = new Solution();
    	System.out.println(sl.minCut("ab"));
    }
}