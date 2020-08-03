public class TreeHeight {
    public static void main(String[] args) {
        TreeHeight treeHeight = new TreeHeight();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;
        System.out.println(treeHeight.maxDepth(one));
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
