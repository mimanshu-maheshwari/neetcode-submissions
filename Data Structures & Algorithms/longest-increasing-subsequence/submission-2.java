class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int len = nums.length;
        int[][] memo = new int[len][len + 1];
        for (int[] arr: memo ){
            Arrays.fill(arr, -1);
        }
        return lis(nums, -1, 0, memo);
    }
    private int lis(int[] nums, int prevIndex, int index, int[][] memo) {
        // return condition 
        if (index == nums.length) {
            return 0;
        }
        if (memo[index][prevIndex + 1] != -1) {
            return memo[index][prevIndex + 1];
        }
        int len = lis(nums, prevIndex, index + 1, memo);
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            len = Math.max(len, 1 + lis(nums, index, index + 1, memo));
        }
        return memo[index][prevIndex + 1] = len;
    }
}
