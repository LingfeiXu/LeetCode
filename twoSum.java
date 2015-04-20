public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers==null||numbers.length<2)
            return res;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(hash.get(numbers[i])!=null) {
                res[0] = hash.get(numbers[i]);
                res[1] = i+1;
                return res;
            } else {
                hash.put(target-numbers[i], i+1);
            }
        }
        return res;
    }
}