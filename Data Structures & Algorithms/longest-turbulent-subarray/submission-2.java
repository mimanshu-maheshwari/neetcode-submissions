public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 0, cnt = 0, sign = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                cnt = (sign == 0) ? cnt + 1 : 1;
                sign = 1;
            } else if (arr[i] < arr[i + 1]) {
                cnt = (sign == 1) ? cnt + 1 : 1;
                sign = 0;
            } else {
                cnt = 0;
                sign = -1;
            }

            res = Math.max(res, cnt);
        }

        return res + 1;
    }
}