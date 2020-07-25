/*
222. Count Complete Tree Nodes
 */
public class CountNodes {
    static class Count {
        int val = 0;
    }
    public static void main(String[] args) {
        CountNodes countNodes = new CountNodes();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;
        System.out.println(countNodes.countNodes(one));
    }
    public int countNodes(TreeNode root) {
        int l = level(root);
        Count count = new Count();
        if (root != null) {
            lessNode(root, count, 0, l);
        }
        int sum = 0;
        int s = 1;
        for (int i = 1; i <= l; i++) {
            sum += s;
            s = s * 2;
        }
        return sum - count.val;
    }

    private void lessNode(TreeNode root, Count count, int currentLevel, int level) {
        if (level == currentLevel) {
            return;
        }
        if (root == null) {
            count.val++;
            return;
        }
        lessNode(root.left, count, currentLevel+1, level);
        lessNode(root.right, count, currentLevel+1, level);
    }

    public int level(TreeNode root) {
        int l = 0;
        while (root != null) {
            l++;
            root = root.left;
        }
        return l;
    }
}
