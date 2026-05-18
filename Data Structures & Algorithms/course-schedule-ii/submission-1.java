class Solution {
    private List<Integer> output;
    private int[] indegree;
    private List<List<Integer>> adj;

    private void dfs(int course) {
        output.add(course);
        indegree[course]--;
        for (int dependentCourse: adj.get(course)) {
            indegree[dependentCourse]--;
            if (indegree[dependentCourse] == 0) {
                dfs(dependentCourse);
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.output = new ArrayList<>();
        // create adjacency list for course graph 
        adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        for (int[] prereq: prerequisites) {
            indegree[prereq[0]]++;
            adj.get(prereq[1]).add(prereq[0]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                dfs(i);
            }
        }
        if (output.size() != numCourses) {
            return new int[0];
        } 
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
