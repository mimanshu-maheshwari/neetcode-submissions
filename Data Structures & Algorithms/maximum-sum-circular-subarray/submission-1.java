class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int left = -1;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int total = 0;
        // find maximum sub array sum 
        for (int right = 0; right < len; right++) { 
            total += nums[right];
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
            if (left < right && currentSum < 0) {
                currentSum = 0;
                left = right;
            }
        }
        maxSum = Math.max(total, maxSum);
        // find largest minimum sub array sum
        left = -1;
        currentSum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int right = 0; right < len; right++) { 
            currentSum += nums[right];
            minSum = Math.min(minSum, currentSum);
            if (left < right && currentSum > 0) { 
                currentSum = 0;
                left = right;
            }
        }
        // max = Math.max(total - minSubArraySum, maxSubArraySum)
        if (minSum != total) {
            maxSum = Math.max(total - minSum, maxSum);
        }
        return maxSum;
    }
}