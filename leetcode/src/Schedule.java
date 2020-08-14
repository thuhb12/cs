import java.util.ArrayList;
import java.util.List;

/*
207. Course Schedule
 */
public class Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = (List<Integer>[]) new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[pre].add(cur);
        }
        return !circle(graph);
    }

    private boolean circle(List<Integer>[] graph) {
        int[] marked = new int[graph.length];
        int[] visited = new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                if (dfs(graph, i, marked, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(List<Integer>[] graph, int s, int[] marked, int[] visited) {
        marked[s] = 1;
        visited[s] = 1;
        for (int u : graph[s]) {
            if (marked[u] == 0) {
                if (dfs(graph, u, marked, visited)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        marked[s] = 0;
        return false;
    }
}
