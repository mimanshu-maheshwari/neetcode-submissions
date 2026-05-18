class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courcePrereqAdjs = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            courcePrereqAdjs.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            courcePrereqAdjs.get(prereq[0]).add(prereq[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int cource = 0; cource < numCourses; cource++) {
            if (!dfs(output, visited, cycle, cource, courcePrereqAdjs)) {
                return new int[0];
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
    private boolean dfs(
        List<Integer> output, Set<Integer> visited, Set<Integer> cycle, int cource, Map<Integer, List<Integer>> adjs) {
            // base condition
            if (cycle.contains(cource)) {
                return false;
            }
            if (visited.contains(cource)) {
                return true;
            }

            // recursive condition
            cycle.add(cource);
            for (int pre : adjs.get(cource)) {
                if (!dfs(output, visited, cycle, pre, adjs)) {
                    return false;
                }
            }
            cycle.remove(cource);
            
            // update params
            visited.add(cource);
            output.add(cource);
            return true;
        }
}
