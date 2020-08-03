import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        three.left = four;
        three.right = one;
        one.right = two;
        System.out.println(binarySearchTree.maxSumBST(three));
//        System.out.println(countNodes.countNodes(one));
    }
    static class Count {
        Integer val;
    }
    public int maxSumBST(TreeNode root) {
        Count count = new Count();
        Map<TreeNode, Integer> map = new HashMap<>();
        Map<TreeNode, Boolean> bstMap = new HashMap<>();
        travel(root, count, map, bstMap);
        return count.val > 0 ? count.val : 0;
    }

    private void travel(TreeNode root, Count count, Map<TreeNode, Integer> map, Map<TreeNode, Boolean> bstMap) {
        if (root == null) {
            if (count.val == null) {
                count.val = 0;
            }
            return;
        }
        if (isBST(root, bstMap)) {
            if (count.val == null) {
                count.val = getSum(root, map);
            } else {
                count.val = Math.max(count.val, getSum(root, map));
            }
        }
        travel(root.left, count, map, bstMap);
        travel(root.right, count, map, bstMap);
    }

    private boolean isBST(TreeNode root, Map<TreeNode, Boolean> map) {
        if (root == null) {
            return true;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }
        if (isBST(root.left, map) && isBST(root.right, map)) {
            if (getMin(root.left) == null || getMin(root.left) < root.val) {
                if (getMax(root.right) == null || getMax(root.right) > root.val) {
                    map.put(root, true);
                    return true;
                }
            }
        }
        map.put(root, false);
        return false;
    }

    private int getSum(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }
        int sum = getSum(root.left, map) + getSum(root.right, map) + root.val;
        map.put(root, sum);
        return sum;
    }

    private Integer getMin(TreeNode root) {
        Integer result = null;
        if (root == null) {
            return result;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private Integer getMax(TreeNode root) {
        Integer result = null;
        if (root == null) {
            return result;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
