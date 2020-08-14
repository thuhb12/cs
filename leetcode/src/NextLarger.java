import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
1019. Next Greater Node In Linked List
 */
public class NextLarger {

    public static void main(String[] args) {
        NextLarger nextLarger = new NextLarger();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        int[] s = nextLarger.nextLarger(list);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return nextLarger(list);
    }

    public int[] nextLarger(List<Integer> nums) {
        int[] s = new int[nums.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.size()-1; i >= 0; i--) {
            int next = add(stack, nums.get(i));
            s[i] = next;
        }
        return s;
    }

    private int add(Stack<Integer> stack, int a) {
        if (stack.size() == 0) {
            stack.add(a);
            return 0;
        } else {
            int t = stack.peek();
            if (a < t) {
                stack.add(a);
                return t;
            } else {
                stack.pop();
                return add(stack, a);
            }
        }
    }
}
