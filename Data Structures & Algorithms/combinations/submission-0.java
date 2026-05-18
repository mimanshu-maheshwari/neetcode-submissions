class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int n, int k, List<Integer> currentResult, List<List<Integer>> result) {
        if (currentResult.size() == k) {
            result.add(new ArrayList<>(currentResult));
            return;
        }

        for (int i = start; i <= n; ++i){ 
            currentResult.add(i);
            backtrack(i + 1, n, k, currentResult, result);
            currentResult.remove(currentResult.size() - 1);
        }
    }
}