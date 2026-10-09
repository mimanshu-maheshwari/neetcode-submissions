class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        Arrays.sort(nums);
        memo = new Boolean[nums.length][sum/2 + 1];
        return dfs(nums, sum/2, 0);
    }
    private boolean dfs(int[] nums, int target, int index) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;
        if (memo[index][target] != null) return memo[index][target];
        
        // include/exclude formulation — cleaner for memoization
        boolean result = dfs(nums, target - nums[index], index + 1)
                  || dfs(nums, target, index + 1);
        
        return memo[index][target] = result;
    }
}
