class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int left = -1;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < len; ++right) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left);
                ++left;
                sum -= nums[left];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}