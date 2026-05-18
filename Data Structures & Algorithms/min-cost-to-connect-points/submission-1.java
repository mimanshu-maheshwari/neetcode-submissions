class DSU {

    int[] parent, size;

    public DSU(int n) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
        }
        size = new int[n + 1];
        Arrays.fill(size, 1);
    }

    public int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public boolean union(int u, int v) {
        int parentU = find(u), parentV = find(v);
        if (parentV == parentU) return false;
        if (size[parentU] < size[parentV]) {
            int temp = parentU;
            parentU = parentV;
            parentV = temp;
        }

        size[parentU] += size[parentV];
        parent[parentV] = parentU;
        return true;
    }

}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; ++i ) {
            for (int j = i + 1; j < n; ++j) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        }
        edges.sort((a,b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for (int[] edge: edges) {
            if (dsu.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }
        return res;
    }
}
