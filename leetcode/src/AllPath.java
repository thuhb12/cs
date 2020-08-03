import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
797. All Paths From Source to Target
 */
public class AllPath {
    public static void main(String[] args) {
        AllPath allPath = new AllPath();
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPath.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> all = new ArrayList<>();
        getPath(0, graph.length-1, new Stack<Integer>(), graph, new int[graph.length], all);
        return all;
    }

    private void getPath(int s, int t, Stack<Integer> path, int[][] graph, int[] visited, List<List<Integer>> all) {
        visited[s] = 1;
        path.push(s);
        if (s == t) {
            List<Integer> list = new ArrayList<>(path);
            all.add(list);
        } else {
            for (int i = 0; i < graph[s].length; i++) {
                int u = graph[s][i];
                if (visited[u] == 0) {
                    getPath(u, t, path, graph, visited, all);
                }
            }
        }
        visited[s] = 0;
        path.pop();
    }
}
