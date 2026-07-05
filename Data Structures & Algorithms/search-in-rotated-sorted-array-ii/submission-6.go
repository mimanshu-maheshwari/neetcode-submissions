func search(nums []int, target int) bool {
	var n = len(nums);
	left := 0;
	right := n - 1;
	for left <= right {
		mid := left + ((right - left) >> 1);
		if nums[mid] == target {
			return true;
		}

		if nums[left] == nums[mid] {
			left++;
			continue;
		}

		if nums[left] < nums[mid] {
		// left half sorted
			if nums[left] <= target && target < nums[mid] {
			// check for sorted half
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		} else {
		// right half sorted
			if nums[mid] < target && target <= nums[right] {
			// check for sorted half
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
	}
	return false;
}
