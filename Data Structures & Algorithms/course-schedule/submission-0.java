class Solution {
    private Set<Integer> visited; 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.visited = new HashSet<>();
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adjs.add(new ArrayList<>());
        }
        for (int[] pre: prerequisites) {
            adjs.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; ++i ) {
            if (!dfs(i, adjs)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int course, List<List<Integer>> adjs) {
        if (visited.contains(course)) {
            return false;
        }

        if (adjs.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (int c : adjs.get(course)) {
            if (!dfs(c, adjs)) {
                return false;
            }
        }

        visited.remove(course);
        return true;
    }
}
