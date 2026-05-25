class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] prefixSum = new int[len];
        prefixSum[0] = nums[0];
        for(int i = 1; i < len; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int left = -1;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < len; ++right) {
            int val = prefixSum[right];
            if (left >= 0) {
                val -= prefixSum[left];
            }
            while (val >= target) {
                minLen = Math.min(minLen, right - left);
                ++left;
                val = prefixSum[right] - prefixSum[left];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}