class Solution {
    private int[][] memo;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        memo = new int[nums.length][2];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        return Math.max(dfs(nums, 0, 1), dfs(nums, 1, 0));
    }

    private int dfs(int[] nums, int index, int flag) {
        if (index >= nums.length || (flag == 1 && index == nums.length - 1)) {
            return 0;
        }
        if (memo[index][flag] != -1) {
            return memo[index][flag];
        }
        return memo[index][flag] = Math.max(
            dfs(nums, index + 2, flag) + nums[index],
            dfs(nums, index + 1, flag)
        );
    }
}
