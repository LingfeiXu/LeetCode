public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> container = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++) {
            for(int j = i+1; j < num.length; j++) {
                int l = j+1;
                int k = num.length-1;
                while(l<k) {
                    int sum = num[i]+num[j]+num[l]+num[k];
                    if (sum>target)
                        k--;
                    else if (sum<target)
                        l++;
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[l]);
                        temp.add(num[k]);
                        
                        if (!container.contains(temp)) {
                            container.add(temp);
                            result.add(temp);
                        }
                        k--;
                        l++;
                    }

                }
                
            }
        }
        return result;
    }
}