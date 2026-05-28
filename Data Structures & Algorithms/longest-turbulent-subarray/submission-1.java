class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int res = 1;
        for (int left = 0; left < len - 1; ++left) {
            if (arr[left] == arr[left + 1]) {
                continue;
            }
            int sign = arr[left] > arr[left + 1] ? 1 : 0;
            int right = left + 1;
            while (right < len - 1) {
                if (arr[right] == arr[right + 1]) {
                    break;
                }
                int currSign = arr[right] > arr[right + 1] ? 1 : 0;
                if (sign == currSign) {
                    break;
                }
                sign = currSign;
                ++right;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}