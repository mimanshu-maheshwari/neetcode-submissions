class Solution {
    public boolean canJump(final int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(max, nums[i] + i);
            System.out.println("max: " + max + ", i: " + i);
            if (max <= i && i != nums.length - 1) {
                return false;
            }
        }
        return true;
    }
}
