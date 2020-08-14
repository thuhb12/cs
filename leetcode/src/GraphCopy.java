import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
133. Clone Graph
 */
public class GraphCopy {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Set<Node> set = new HashSet<>();
        cloneGraph(node, map);
        dfs(node, map, set);
        return map.get(node);
    }

    private void cloneGraph(Node node, Map<Node, Node> map) {
        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node child : node.neighbors) {
            if(!map.keySet().contains(child)) {
                cloneGraph(child, map);
            }
        }
    }

    private void dfs(Node node, Map<Node, Node> map, Set<Node> visited) {
        visited.add(node);
        Node current = map.get(node);
        for (Node child : node.neighbors) {
            current.neighbors.add(map.get(child));
            if (!visited.contains(child)) {
                dfs(child, map, visited);
            }
        }
    }
}
