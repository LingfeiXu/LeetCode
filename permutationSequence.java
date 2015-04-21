public class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        ArrayList<Integer> temp4 = new ArrayList<Integer>();
        for(int i = 1; i <=n; i++) {
            temp4.add(i);
        }
        int temp1 = n;
        int temp3 = 0;
        int temp2 = 1, temp5 = 0;
        for(int i = 1; i < temp1; i++) {
            temp2 = i*temp2;
            temp3 = i;
        }        
        while(temp3>=1) {
            int pos2 = k%temp2;
            int pos1 = k/temp2;
            if(pos2==0) {
            	if(pos1==0) {
            		pos1 = 1;
            		temp5 = temp4.get(pos1-1);
            	} else {
            		temp5 = temp4.get(pos1-1);;
            		res = res + temp5;
                    temp4.remove(new Integer(temp5));
            		while(!temp4.isEmpty()){
            			int temp6 = temp4.get(temp4.size()-1);
            			res = res + temp6;
            			temp4.remove(new Integer(temp6));
            		}
            		return res;
            	}
            } else {
            	temp5 = temp4.get(pos1);
            }
            res = res + temp5;
            temp4.remove(new Integer(temp5));
            k = pos2;
            temp2 = temp2/temp3;
            temp3--;
        }
        res = res + temp4.get(0);
        return res;
    }
}