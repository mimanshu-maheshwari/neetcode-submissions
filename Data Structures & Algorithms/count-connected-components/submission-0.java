class DSU {
    private int[] parent, size;
    private int comp;
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        comp = n;
        for (int i = 0; i < n; ++i) {
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
        int pv  = find(v);
        if(pu == pv) {
            return false;
        }
        comp--;
        if (size[pu] <size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] += size[pv];
        parent[pv] = pu;
        return true;
    }
    public int components() {
        return comp;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        var dsu = new DSU(n);
        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.components();
    }
}
