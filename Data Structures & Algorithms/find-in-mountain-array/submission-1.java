/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 1;
        int right = len - 2;
        int peak = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int l = mountainArr.get(mid - 1);
            int r = mountainArr.get(mid + 1);
            int m = mountainArr.get(mid);
            if (l < m && m < r) {
                left = mid + 1;
            } else if (l > m && m > r) {
                right = mid - 1;
            } else {
                peak = mid;
                break;
            }
        }
        // search left
        left = 0;
        right = peak - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int val = mountainArr.get(mid);
            if (val < target) {
                left = mid + 1;
            } else if (val > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        left = peak;
        right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int val = mountainArr.get(mid);
            if (val > target) {
                left = mid + 1;
            } else if (val < target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}