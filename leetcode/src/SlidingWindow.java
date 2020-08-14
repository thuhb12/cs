import java.util.ArrayList;
import java.util.List;

/*
剑指 Offer 59 - I. 滑动窗口的最大值 LCOF
 */
public class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] m = {1, 3, -1, -3};
        int[] s = slidingWindow.maxSlidingWindow(m, 5);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
    class Node {
        int val;
        int index;
        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            add(list, nums[i], i);
        }
        int[] s = new int[nums.length+1-k];
        s[0] = list.get(0).val;
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            add(list, nums[i], i);
            delete(list, j);
            s[j++] = list.get(0).val;
        }
        return s;
    }

    private void add(List<Node> list, int a, int p) {
        if (list.size() == 0) {
            list.add(new Node(a, p));
        } else {
            Node last = list.get(list.size()-1);
            if (last.val < a) {
                list.remove(list.size()-1);
                add(list, a, p);
            } else {
                list.add(new Node(a, p));
            }
        }
    }

    private void delete(List<Node> list, int p) {
        while (list.size() > 0) {
            Node first = list.get(0);
            if (first.index < p) {
                list.remove(0);
            } else {
                return;
            }
        }
    }
}
