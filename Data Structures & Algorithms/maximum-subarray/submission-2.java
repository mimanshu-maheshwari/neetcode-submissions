class Solution {
    public int maxSubArray(int[] nums) {
        int total = 0;
        int cut = 0;
        int best = nums[0];
        for (int num : nums) {
            if (cut < 0) {
                total = total - cut;
                cut = 0;
            }
            total += num;
            cut += num;
            if (total > best) {
                best = total;
            }
        }

        return best;
    }
}
