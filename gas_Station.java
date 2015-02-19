public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int left = 0;
        int start = 0, total = 0;
        for(int i=0; i<n; i++) {
            left += gas[i]-cost[i];
            total += gas[i]-cost[i];
            if(left<0) {
                left = 0;
                start =i+1;
            }
        }
        if(total<0) {
            return -1;
        } else {
            return start;   
        }
    }
}

// class Solution {
// public:
    // int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        // int restGas=0;
        // int beg=0;
        // for(int i=0; i<gas.size(); ++i){
            // restGas += gas[i]-cost[i];
            // if(restGas<0){
                // restGas=0;
                // beg = i+1;  
            // }
        // }
        // if(beg>=gas.size())
            // return -1;
        // int j=beg, num=0;
        // restGas = 0;
        // while(num<gas.size()){
            // restGas += gas[j]-cost[j];
            // if(restGas<0)
                // return -1;
            // num++;
            // j = (j+1)%gas.size();
        // }
        // return beg;
    // }
// }