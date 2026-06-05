class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            total += gas[i] - cost[i]; 
            sum += gas[i] - cost[i];
            if (sum < 0){
                start = i + 1;
                sum = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
