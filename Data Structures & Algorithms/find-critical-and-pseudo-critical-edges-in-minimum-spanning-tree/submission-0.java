class DSU {
    private int[] parent, size;
    public DSU(int k) {
        this.parent = new int[k];
        this.size = new int[k];
        for (int i = 0; i < k ; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] += size[pv];
        parent[pv] = pu;
        return true;
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int mstCost = mst(n, edges, -1, -1);
        var criticalEdges = new ArrayList<Integer>();
        var pseudoCriticalEdges = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; ++i) {
            var criticalCheck = mst(n, edges, i, -1);
            if (criticalCheck > mstCost) {
                criticalEdges.add(i);
                continue;
            } 
            var pseudoCriticalCheck = mst(n, edges, -1, i);
            if (pseudoCriticalCheck == mstCost) {
                pseudoCriticalEdges.add(i);
            } 
        }
        return List.of(criticalEdges, pseudoCriticalEdges);
    }

    private int mst(int n, int[][] edges, int ignoreEdge, int forceEdge) {
        var dsu = new DSU(n);
        int usedEdges = 0;
        // var result = new ArrayList<int[]>();
        var minHeap = new PriorityQueue<int[]>(Comparator.comparing(a -> a[2]));
        int cost = 0;
        for (int i = 0; i < edges.length; ++i) {
            if (ignoreEdge == i) {
                continue;
            }
            var edge = edges[i];
            if (forceEdge == i) {
                dsu.union(edge[0], edge[1]);
                cost += edge[2];
                usedEdges++;
            }else {
                minHeap.offer(edge);
            }
        }
        while (!minHeap.isEmpty()) {
            var curr = minHeap.poll();
            int a = curr[0], b = curr[1], w = curr[2];
            if (dsu.union(a, b)){
                usedEdges++;
                cost += w;
                // result.add(curr);
            }
        }
        // if mst is disconnected then it is critical and cost will increase
        return usedEdges + 1 == n ? cost : Integer.MAX_VALUE;
    }
}