class UnionFind {
    int[] parent, size;
    public UnionFind(int k){
        parent = new int[k + 1];
        for (int i = 0; i <= k; ++i) {
            parent[i] = i;
        }
        size = new int[k + 1];
        Arrays.fill(size, 1);
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        if (parentU == parentV) {
            return false;
        }
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        UnionFind uf = new UnionFind(len);
        Map<String, Integer> emailToAccIdx = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); ++j) {
                if (emailToAccIdx.containsKey(account.get(j))) {
                    uf.union(i, emailToAccIdx.get(account.get(j)));
                } else {
                    emailToAccIdx.put(account.get(j), i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToAccIdx.entrySet()) {
            String email = entry.getKey();
            int index = entry.getValue();
            int parent = uf.find(index);
            emailGroup.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int index = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String accountName = accounts.get(index).get(0);
            emails.add(0, accountName);
            result.add(emails);
        }
        return result;
    }
}