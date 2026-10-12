class Solution {
    HashMap<String, PriorityQueue<String>> adj;
    final String JFK = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for (var ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        var result = new ArrayList<String>();
        dfs(JFK, result);

        Collections.reverse(result);
        return result;

    }
    private void dfs(String src, List<String> result) {
        var queue = adj.get(src);
        while (queue != null && !queue.isEmpty()) {
            var dst = queue.poll();
            dfs(dst, result);
        }
        result.add(src);
    }
}
