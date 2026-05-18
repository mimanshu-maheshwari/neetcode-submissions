class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        int LIS = 1;

        for (int i = 1; i < nums.length ; ++i) {
            if (dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
                ++LIS;
                continue;
            }
            int index = Collections.binarySearch(dp, nums[i]);
            if (index < 0) {
                index = -index - 1;
            }
            dp.set(index, nums[i]);
        }
        return LIS;
    }
}
