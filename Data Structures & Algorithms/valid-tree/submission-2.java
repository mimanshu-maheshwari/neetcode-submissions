class DSU {
    private int[] parent, size; 
    private int comp;
    public DSU(int k) {
        parent = new int[k];
        size = new int[k];
        for (int i = 0; i< k; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
        comp = k;
    }
    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        comp--;
        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv; 
            pv = temp;
        }
        parent[pv] = pu;
        size[pu] += size[pv];
        return true;
    }
    public int components(){
        return comp;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) {
            return false;
        }
        var dsu = new DSU(n);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }

        return dsu.components() == 1;
    }
}
