import java.util.ArrayList;
import java.util.List;

/*
513. Find Bottom Left Tree Value
 */
public class BottomLeft {
    public static void main(String[] args) {
        BottomLeft bottomLeft = new BottomLeft();

    }
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> s = new ArrayList<>();
        List<TreeNode> t = new ArrayList<>();
        s.add(root);
        int m = root.val;
        while (s.size() > 0) {
            m = s.get(0).val;
            for (TreeNode node : s) {
                if (node.left != null) {
                    t.add(node.left);
                }
                if (node.right != null) {
                    t.add(node.right);
                }
            }
            s = t;
            t = new ArrayList<>();
        }
        return m;
    }
}
