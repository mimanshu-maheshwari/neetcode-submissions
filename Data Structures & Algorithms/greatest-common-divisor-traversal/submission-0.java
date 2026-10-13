class DSU {
    private int[] parent, size; 
    private int connections;

    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(this.size, 1);
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
        }
        this.connections = n;
    }

    public int find(int x) {
        if (this.parent[x] != x) {
            this.parent[x] = this.find(this.parent[x]);
        }
        return parent[x];
    }

    public boolean union(int u, int v) {
        int pu = this.find(u);
        int pv = this.find(v);
        if (pu == pv) {
            return false;
        }
        if (pu < pv) {
            int temp = pv;
            pv = pu;
            pu = temp;
        }

        this.parent[pv] = pu;
        this.size[pu] += this.size[pv];

        this.connections--;
        return true;
    }

    public boolean allConnected() {
        return this.connections == 1;
    }

}
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        final int len = nums.length;
        var dsu = new DSU(len);
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (gcd(nums[i], nums[j]) > 1) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.allConnected();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return this.gcd(b, a % b);
    }
}