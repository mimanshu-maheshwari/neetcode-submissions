class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int robTwoOld = 0;
        int robOneOld = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            int currentMax = Math.max(robTwoOld + nums[i], robOneOld);
            robTwoOld = robOneOld;
            robOneOld = currentMax;
        }
        int incOne = robOneOld;
        robTwoOld = 0;
        robOneOld = 0;
        for (int i = 1; i < nums.length; i++) {
            int currentMax = Math.max(robTwoOld + nums[i], robOneOld);
            robTwoOld = robOneOld;
            robOneOld = currentMax;
        }

        return Math.max(incOne, robOneOld);
    }
}