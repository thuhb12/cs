import java.util.Stack;
/*
150. Evaluate Reverse Polish Notation
 */
public class Evalrpn {
    public static void main(String[] args) {
        Evalrpn evalrpn = new Evalrpn();
        String[] tokens =  {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalrpn.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (checkNumber(tokens[i])) {
                int a = Integer.valueOf(tokens[i]);
                stack.push(a);
            } else {
                switch (tokens[i]) {
                    case "+" :
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a + b);
                        break;
                    case "-" :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b - a);
                        break;
                    case "*" :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a * b);
                        break;
                    case "/" :
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean checkNumber(String s) {
        try {
            Integer.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
