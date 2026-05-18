class Solution {

    private Map<String , Integer>      emailToIdx = new HashMap<>();
    private Map<Integer, Integer>      idxToAccId = new HashMap<>();
    private List<String>               emails     = new ArrayList<>();
    private Map<Integer, List<String>> emailGroup = new HashMap<>();

    private List<List<Integer>>        adj        = new ArrayList<>();
    private boolean[]                  visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int m = 0;
        // email -> index -> account id
        for (int accId = 0; accId < n; ++accId){
            List<String> account = accounts.get(accId);
            for (int i = 1; i < account.size(); ++i) {
                String email = account.get(i);
                if (!emailToIdx.containsKey(email)) {
                    emails.add(email);
                    emailToIdx.put(email, m);
                    idxToAccId.put(m, accId);
                    ++m;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            adj.add(new ArrayList<>());
        }

        for (List<String> account: accounts) {
            for (int i = 2; i < account.size(); ++i ){
                int id1 = emailToIdx.get(account.get(i));
                int id2 = emailToIdx.get(account.get(i - 1));
                adj.get(id1).add(id2);
                adj.get(id2).add(id1);
            }
        }

        visited = new boolean[m];

        for (int i = 0; i < m; ++i) {
            if (!visited[i]) {
                int accId = idxToAccId.get(i);
                emailGroup.putIfAbsent(accId, new ArrayList<>());
                dfs(i, accId);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (int accId : emailGroup.keySet()) {
            List<String> group = emailGroup.get(accId);
            Collections.sort(group);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(group);
            res.add(merged);
        }

        return res;
    }

    private void dfs(int node, int accId) {
        visited[node] = true;
        emailGroup.get(accId).add(emails.get(node));
        for (int neighbor: adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, accId);
            }
        }
    }

}