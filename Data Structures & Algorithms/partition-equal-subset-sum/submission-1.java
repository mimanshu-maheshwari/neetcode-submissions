class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        Arrays.sort(nums);
        return dfs(nums, sum/2, 0);
    }

    private boolean dfs(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }

        if (index >= nums.length) {
            return false;
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
        return false;
    }
}
