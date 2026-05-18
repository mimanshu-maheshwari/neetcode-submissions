class Solution {
    public void sortColors(int[] nums) {
        partition(nums);
    }

    private void partition(int[] nums) {
        int i = 0, j = nums.length - 1, k = 0;
        int pivot = 1;
        while (k <= j) {
            if (nums[k] < pivot) {
                swap(nums, i++, k);
            } else if (nums[k] > pivot) {
                swap(nums, j--, k--);
            } 
            k++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}