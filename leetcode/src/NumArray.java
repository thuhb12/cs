/*
307. Range Sum Query - Mutable
 */
public class NumArray {

    static class Node {
        int low;
        int high;
        int sum;
        Node left;
        Node right;
    }

    private int[] nums;
    private Node root;
    public NumArray(int[] nums) {
        this.nums = nums;
        root = generate(nums, 0, nums.length-1);
    }

    private Node generate(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        } else if (low == high) {
            Node node = new Node();
            node.low = low;
            node.high = high;
            node.sum = nums[low];
            return node;
        } else {
            int mid = low + (high - low) / 2;
            Node left = generate(nums, low, mid);
            Node right = generate(nums, mid+1, high);
            Node current = new Node();
            current.low = low;
            current.high = high;
            current.sum = left.sum + right.sum;
            current.left = left;
            current.right = right;
            return current;
        }
    }

    private void update(Node node, int i, int val) {
        if (i >= node.low && i <= node.high) {
            if (node.low == node.high) {
                node.sum = val;
            } else {
                update(node.left, i, val);
                update(node.right, i, val);
                node.sum = node.left.sum + node.right.sum;
            }
        }
    }

    public void update(int i, int val) {
        nums[i] = val;
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(Node node, int i, int j) {
        if (node.low == i && node.high == j) {
            return node.sum;
        } else if (i > node.high) {
            return 0;
        } else if (j < node.low) {
            return 0;
        } else if (i <= node.low && j >= node.high) {
            return node.sum;
        } else if (i >= node.low && j <= node.high) {
          return sumRange(node.left, i, j) + sumRange(node.right, i, j);
        } else if (node.low > i){
            return sumRange(node, node.low, j);
        } else if (j > node.high) {
            return sumRange(node, i, node.high);
        }
        return 0;
    }
}