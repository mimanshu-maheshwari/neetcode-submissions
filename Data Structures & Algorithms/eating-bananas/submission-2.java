class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = piles[0];
        for (int p: piles){
            l = Math.min(p, l);
            r = Math.max(p, r);
        }
        int res = r;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (hrsToEat(piles, m) > h) {
                l = m + 1;
            } else {
                res = m;
                r = m - 1;
            }
        }
        return res;
    }
    private int hrsToEat(int[] piles, int k) {
        int result = 0;
        for (int p: piles) {
            result += (p % k == 0) ? (p / k) : ((p / k) + 1);
        }
        return result;
    }
}
