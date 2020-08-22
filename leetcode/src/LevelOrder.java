/*
103. Binary Tree Zigzag Level Order Traversal
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> src = new ArrayList<>();
        src.add(root);
        List<TreeNode> target = new ArrayList<>();
        boolean flag = false;
        while (src.size() > 0) {
            List<Integer> current = new ArrayList<>();
            for (TreeNode node : src) {
                if (node.left != null) {
                    target.add(node.left);
                }
                if (node.right != null) {
                    target.add(node.right);
                }
                if (flag) {
                    current.add(0, node.val);
                } else {
                    current.add(node.val);
                }
            }
            list.add(current);
            src = target;
            target = new ArrayList<>();
            if (flag) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> src = new ArrayList<>();
        src.add(root);
        List<TreeNode> target = new ArrayList<>();
        while (src.size() > 0) {
            List<Integer> current = new ArrayList<>();
            for (TreeNode node : src) {
                if (node.left != null) {
                    target.add(node.left);
                }
                if (node.right != null) {
                    target.add(node.right);
                }
                current.add(node.val);
            }
            list.add(current);
            src = target;
            target = new ArrayList<>();
        }
        Collections.reverse(list);
        return list;
    }
}
