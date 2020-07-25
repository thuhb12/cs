import java.util.Stack;

public class ScoreOfParenthes {
    public static void main(String[] args) {
        ScoreOfParenthes scoreOfParenthes = new ScoreOfParenthes();
        System.out.println(scoreOfParenthes.scoreOfParentheses("()(())"));
    }
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            add(stack, String.valueOf(S.charAt(i)));
        }
        return Integer.valueOf(stack.pop());
    }

    private void add(Stack<String> stack, String s) {
        if (stack.size() == 0) {
            stack.push(s);
        }
        if (s.equals(")")) {
            String left = stack.pop();
            if (left.equals("(")) {
                add(stack, "1");
            } else {
                String pre = stack.pop();
                add(stack, String.valueOf(Integer.valueOf(left)*2));
            }
        } else if (s.equals("(")) {
            stack.push(s);
        } else {
            String left = stack.peek();
            if (left.equals("(")) {
                stack.push(s);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(s);
                add(stack, String.valueOf(a + b));
            }
        }
    }
}
