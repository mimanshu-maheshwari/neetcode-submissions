class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if (nums[i] + nums[len-1] + nums[len-2] < 0) continue; // ← new

            if (i > 0 && nums[i] == nums[i-1]) continue;

            int fixed = nums[i]; // ← renamed
            int left = i + 1, right = len - 1;

            while (left < right) {
                int sum = fixed + nums[left] + nums[right];
                if      (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    result.add(List.of(fixed, nums[left], nums[right]));
                    left++; right--;
                    while (left < right && nums[left]  == nums[left-1])  left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return result;
    }
}