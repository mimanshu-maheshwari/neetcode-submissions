class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = nums[0], max = nums[0];
        int minSum = 0, maxSum = 0, total = 0;
        for (int num: nums) {
            total += num;
            minSum = Math.min(minSum + num, num);
            maxSum = Math.max(maxSum + num, num);
            min = Math.min(min, minSum);
            max = Math.max(max, maxSum);
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}