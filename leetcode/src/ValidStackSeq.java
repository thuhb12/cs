import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
946. Validate Stack Sequences
 */
public class ValidStackSeq {
    public static void main(String[] args) {
        ValidStackSeq validStackSeq = new ValidStackSeq();
        int[] s = {1, 2, 3, 4, 5};
        int[] t = {4, 3, 5, 1, 2};
        System.out.println(validStackSeq.validateStackSequences(s, t));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < pushed.length; i++) {
            list.add(pushed[i]);
        }
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < popped.length; i++) {
            int current = popped[i];
            if (left.size() == 0) {
                if (add(left, list, current)) {

                } else {
                    return false;
                }
            } else if (left.peek() == current) {
                left.pop();
            } else {
                if (add(left, list, current)) {

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean add(Stack<Integer> stack, List<Integer> list, int current) {
        while (list.size() > 0) {
            int start = list.remove(0);
            if (start != current) {
                stack.add(start);
            } else {
                return true;
            }
        }
        return false;
    }
}
