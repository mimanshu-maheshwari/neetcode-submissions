class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a, b;
        if (nums1.length <= nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }
        int l1 = a.length, l2 = b.length;
        int total = (l1 + l2);
        int half = (total + 1) >> 1;
        
        int l = 0, r = l1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int j = half - mid;

            int aleft = mid > 0 ? a[mid - 1] : Integer.MIN_VALUE;
            int aright = mid < l1 ? a[mid] : Integer.MAX_VALUE;
            int bleft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
            int bright = j < l2 ? b[j] : Integer.MAX_VALUE;

            if (aleft <= bright && bleft < aright) {
                if ((total & 1) == 1) {
                    return Math.max(aleft, bleft);
                }
                return ((Math.max(aleft, bleft) + Math.min(aright, bright))/ 2.0);
            } else if (aleft > bright) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
