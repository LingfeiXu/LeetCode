public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = num.length/2;
        for(int i:num) {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
            if(map.get(i)>len)
                return i;
        }
        return -1;
    }
}