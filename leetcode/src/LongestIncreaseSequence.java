import java.util.ArrayList;
import java.util.List;

/*
300. Longest Increasing Subsequence
 */
public class LongestIncreaseSequence {
    class Node {
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    public int lengthOfLIS(int[] nums) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            add(list, nums[i]);
        }
        return list.size();
    }

    private void add(List<Node> list, int val) {
        if (list.size() == 0) {
            list.add(new Node(val));
        }
        int last = list.get(list.size()-1).val;
        if (val > last) {
            list.add(new Node(val));
            return;
        } else if (val == last) {
            return;
        }

        for (int i = list.size()-1; i >= 0; i--) {
            Node node = list.get(i);
            if (val == node.val) {
                return;
            } else if (val < node.val) {
            } else if (val > node.val) {
                Node current = list.get(i+1);
                current.val = val;
                return;
            }
        }
        Node current = list.get(0);
        current.val = val;
    }
}
