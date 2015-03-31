public class Solution {
    public List<List<Integer>> threeSum(int[] num){ 
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num.length<3)
            return res;
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++) {
            if(i==0||num[i]>num[i-1]) {
                int left = -num[i];
                int start = i + 1;
                int end = num.length -1;
                while(start < end) {
                    if(num[start] + num[end] == left) {
                    	List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        res.add(temp);
                        start++;
                        end--;
                        while(start<end&&num[start]==num[start-1]) {
                            start++;
                        }
                        while(start<end&&num[end]==num[end+1]) {
                            end--;
                        }                    
                    } else if (num[start] + num[end] < left) {
                        start++;
                    } else {
                        end--;
                    }                	
                }
                
            }
        }
        return res;
    }
}