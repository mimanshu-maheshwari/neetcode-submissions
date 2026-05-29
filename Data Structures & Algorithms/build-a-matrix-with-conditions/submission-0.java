class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, Integer> rowOrder = topoSort(rowConditions, k);
        if (null == rowOrder || rowOrder.isEmpty() ){
            return new int[0][0];
        }
        Map<Integer, Integer> colOrder = topoSort(colConditions, k);
        if (null == colOrder || colOrder.isEmpty()) {
            return new int[0][0];
        }
        int[][] res = new int[k][k];
        for (int num = 1; num <= k; ++num) {
            int r = rowOrder.get(num);
            int c = colOrder.get(num);
            res[r][c] = num;
        }
        return res;
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visit, Set<Integer> path, List<Integer> order) {
        if (path.contains(src)) {
            return false;
        }
        if (visit.contains(src)){
            return true;
        }
        visit.add(src);
        path.add(src);
        for(int n: adj.get(src)){
            if (!dfs(n, adj, visit, path, order)) {
                return false;
            }
        }
        path.remove(src);
        order.add(src);
        return true;
    }

    private Map<Integer, Integer> topoSort(int[][] edges, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= k; ++i) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        Set<Integer> visit = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 1; i <= k; ++i){
            if (!visit.contains(i)) {
                if (!dfs(i, adj, visit, path, order)) {
                    return null;
                }
            }
        }

        Collections.reverse(order);
        return IntStream.range(0, order.size()).boxed().collect(Collectors.toMap(
            order::get,
            i -> i
        ));
    }
}