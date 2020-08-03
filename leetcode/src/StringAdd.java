import java.util.Stack;
/*
415. Add Strings
 */
public class StringAdd {
    public String addStrings(String num1, String num2) {
        Stack<Integer> left = string2Stack(num1);
        Stack<Integer> right = string2Stack(num2);
        Stack<Integer> result = new Stack<>();
        int c = 0;
        while (left.size() > 0 && right.size() > 0) {
            int a = left.pop();
            int b = right.pop();
            int s = (a + b + c) % 10;
            result.push(s);
            c = (a + b + c) / 10;
        }
        Stack<Integer> stack = left.size() == 0 ? right : left;
        while (stack.size() > 0) {
            int a = stack.pop();
            int s = (a + c) % 10;
            result.push(s);
            c = (a + c) / 10;
        }
        if (c != 0) {
            result.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(result.size() > 0) {
            stringBuilder.append(result.pop() + "");
        }
        return stringBuilder.toString();
    }

    private Stack<Integer> string2Stack(String num) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            stack.add(Integer.valueOf(num.charAt(i)+""));
        }
        return stack;
    }
}
