record Pair(String node, Double value){}
class Solution {
    public double[] calcEquation(
        List<List<String>> equations,
        double[] values, 
        List<List<String>> queries
    ) {
        int qlen = queries.size();
        // create adjacency list 
        // Map of a -> [b, value of a/b]
        // Map of b -> [a, value of b/a]
        var adjacencyList = new HashMap<String, List<Pair>>();
        for (int i = 0; i < values.length; ++i) {
            adjacencyList.computeIfAbsent(equations.get(i).get(0), k -> new ArrayList<>());
            adjacencyList.computeIfAbsent(equations.get(i).get(1), k -> new ArrayList<>());
            adjacencyList.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            adjacencyList.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1 / values[i]));
        }
        double[] result = new double[qlen];
        for (int i = 0; i < qlen; ++i) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adjacencyList);
        }
        return result;
    }

    private double bfs(String source, String target, HashMap<String, List<Pair>> adjs) {
        if (!adjs.containsKey(source) || !adjs.containsKey(target)) {
            return -1.0;
        }

        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(source, 1.0));
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0){
                Pair val = queue.poll();
                if (!adjs.containsKey(val.node()) || visited.contains(val.node())) {
                    continue;
                }
                for (Pair p : adjs.get(val.node())) {
                    if (target.equals(p.node())) {
                        return val.value() * p.value();
                    }
                    queue.offer(new Pair(p.node(), val.value() * p.value()));
                }
                visited.add(val.node());
            }
        }
        return -1.0;
    }

}