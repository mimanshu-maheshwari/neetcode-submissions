class Solution {
    int visited = 0;
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        if (sum % k != 0) {
            return false;
        }

        this.target = sum / k;
        this.visited = 0;
        return backtrack(nums, 0, 0, k);
    }

    private boolean backtrack(int[] nums, int index, int currSum, int k) {
        if (k == 0) {
            return true;
        }

        if (currSum == this.target) {
            return backtrack(nums, 0, 0, k - 1);
        }

        for (int i = index; i < nums.length; ++i) {
            if (((visited >> i) & 1) == 1 || currSum + nums[i] > target) {
                continue;
            }
            visited = (visited ^ (1 << i));
            if (backtrack(nums, i + 1, currSum + nums[i], k)) {
                return true;
            }
            visited = (visited ^ (1 << i));
        }
        return false;

    }

}