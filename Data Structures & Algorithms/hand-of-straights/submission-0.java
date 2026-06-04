class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 0 || hand.length % groupSize != 0){ 
            return false;
        }
        Arrays.sort(hand);
        var count = new HashMap<Integer, Integer>();
        for (int h: hand) {
            count.merge(h, 1, Integer::sum);
        }
        var result = new int[hand.length / groupSize][groupSize];
        var indices = new int[hand.length / groupSize];
        Arrays.fill(indices, -1);
        for (int h: hand) {
            boolean inserted = false;
            for (int i = 0; i < indices.length; ++i) {
                if (indices[i] >= groupSize - 1) {
                    continue;
                }
                if (indices[i] == -1 || result[i][indices[i]] + 1 == h) {
                    indices[i]++;
                    result[i][indices[i]] = h;
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                return false;
            }
        }
        return true;
    }

}
