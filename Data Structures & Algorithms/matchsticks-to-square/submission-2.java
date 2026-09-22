class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        
        // Sort descending — large pieces fail fast, prunes heavily
        Integer[] arr = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        return dfs(arr, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(Integer[] arr, int[] sides, int index, int target) {
        if (index == arr.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        Set<Integer> tried = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            if (tried.contains(sides[i])) continue;  // skip duplicate side lengths
            if (sides[i] + arr[index] <= target) {
                tried.add(sides[i]);
                sides[i] += arr[index];
                if (dfs(arr, sides, index + 1, target)) return true;
                sides[i] -= arr[index];
            }
        }
        return false;
    }
}