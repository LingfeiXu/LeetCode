public class Solution {
    public String largestNumber(int[] num) {
	     String[] NUM = new String[num.length];
	 
	    for (int i = 0; i <num.length; i++) {
	        NUM[i] = String.valueOf(num[i]);
	    }
	 
	    Arrays.sort(NUM, new java.util.Comparator<String>() {
	        public int compare(String left, String right) {
	            String leftRight = left.concat(right);
	            String rightLeft = right.concat(left);
	            return rightLeft.compareTo(leftRight);
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < NUM.length; i++) {
	        sb.append(NUM[i]);
	    }
	 
	    java.math.BigInteger result = new java.math.BigInteger(sb.toString());
	    return result.toString();
	}
}