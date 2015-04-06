public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null||digits.length()==0)
            return res;
        HashMap<Character, String> hash = new HashMap<Character, String>();
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        for(int i = 0; i < digits.length(); i++) {
            char temp = digits.charAt(i);
            String temp2 = hash.get(temp);
            if(i == 0) {
            	for(int j = 0; j < temp2.length(); j++) {
                	char temp4 = temp2.charAt(j);
                	res.add(Character.toString(temp4));
                }
            }
            else {
            	int resSize = res.size();
            	for(int k = 0; k < resSize; k++) {
                    String temp3 = res.get(0);
                    res.remove(temp3);
                    for(int j = 0; j < temp2.length(); j++) {
                    	String temp5 = temp3 + temp2.charAt(j);
                    	res.add(temp5);
                    }
                }
            }
        }
        return res;
    }
}