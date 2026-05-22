class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int maxSum = -1001;
        int currSum = 0;
        for (int right = 0; right < len; ++right) {
            currSum += nums[right];
            if (maxSum < currSum){
                maxSum = Math.max(maxSum, currSum);
            }
            if (currSum < 0) {
                currSum = 0;
                left = right + 1;
            }
        }
        return maxSum;
    }
}
