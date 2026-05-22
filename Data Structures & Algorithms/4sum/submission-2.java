class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < len - 3; ++i) {
            int a = nums[i];
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long) a + b + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(List.of(a, b, nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                    while (left < right && left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && right < len - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}