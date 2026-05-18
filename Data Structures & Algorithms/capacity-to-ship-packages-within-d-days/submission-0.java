class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight= 0;
        int sum = 0;
        for (int w: weights) {
            maxWeight = Math.max(w, maxWeight);
            sum += w;
        }
        int res = sum;
        int l = maxWeight, r = sum;
        while (l <= r) {
            int cap = (l + r) >> 1;
            if (canShip(cap, days, weights)) {
                res = Math.min(res, cap);
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }
        return res;

    }
    boolean canShip(int cap, int days, int [] weights) {
        int ships = 1, currCap = cap;
        for (int w: weights) {
            if (currCap - w < 0) {
                ++ships;
                if (ships > days) {
                    return false;
                }
                currCap = cap;
            }
            currCap -= w;
        }
        return true;
    }
}