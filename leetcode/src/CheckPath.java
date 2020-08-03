import java.util.ArrayList;
import java.util.List;

public class CheckPath {
    public static void main(String[] args) {
        CheckPath checkPath = new CheckPath();
        System.out.println();
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = (List<Integer>[]) new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph[a].add(b);
        }
        int[] visited = new int[n];
        int[][] reach = new int[n][n];
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path(i, j, graph, visited, reach);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            result.add((reach[queries[i][0]][queries[i][1]] == 1));
        }
        return result;
    }

    private void path(int s, int t, List<Integer>[] graph, int[] visited, int[][] reach) {
        if (reach[s][t] != 0) {
            return ;
        }
        if (s == t) {
            reach[s][t] = 1;
        }
        visited[s] = 1;
        for (int u : graph[s]) {
            if (visited[u] == 0) {
                path(u, t, graph, visited, reach);
                if (reach[u][t] == 1) {
                    reach[s][t] = 1;
                }
            }
        }
        visited[s] = 0;
        if (reach[s][t] == 0) {
            reach[s][t] = -1;
        }
    }
}
