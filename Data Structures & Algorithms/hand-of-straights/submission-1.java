class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 0 || hand.length % groupSize != 0) {
            return false;
        }
        var count = new HashMap<Integer, Integer>();
        for (int h: hand) {
            count.merge(h, 1, Integer::sum);
        }
        Arrays.sort(hand);
        for (int h: hand) {
            if (count.get(h) > 0 ){
                for (int i = h; i < h + groupSize; ++i ) {
                    if (count.getOrDefault(i, 0) == 0) {
                        return false;
                    }
                    count.merge(i, -1, Integer::sum);
                }

            }
        }
        return true;
    }
}
