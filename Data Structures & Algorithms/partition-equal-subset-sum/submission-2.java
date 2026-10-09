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
        if (target == 0) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        if (memo[index][target] != null){
            return memo[index][target];
        }

        for (int i = index; i < nums.length; ++i) {
            if (target >= nums[i]) {
                if (dfs(nums, target - nums[i], i + 1)) {
                    return true;
                }
            } else {
                break;
            }
        }
        return memo[index][target] = false;
    }
}
