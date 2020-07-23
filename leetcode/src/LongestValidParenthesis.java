/*
32. Longest Valid Parentheses
 */

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        LongestValidParenthesis longestValidParenthesis = new LongestValidParenthesis();
        System.out.println(longestValidParenthesis.longestValidParentheses("(()"));
    }

//    public int longestValidParentheses(String s) {
//        if (s.length() == 0 || s.length() == 1) {
//            return 0;
//        }
//        int[][] cache = new int[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                cache[i][j] = -1;
//            }
//        }
//        for (int j = 0; j < s.length(); j++) {
//            cache[j][j] = 0;
//        }
//
//        return longestValidParentheses(s, cache, 0, s.length()-1);
//    }
//
//    private int longestValidParentheses(String s, int[][] cache, int left, int right) {
//        if (left >= right) {
//            cache[left][left] = 0;
//            return 0;
//        }
//        if (cache[left][right] != -1) {
//            return cache[left][right];
//        }
//        if (right == left + 1) {
//            if (s.charAt(left) == '(' && s.charAt(right) == ')') {
//                cache[left][right] = 2;
//                return 2;
//            } else {
//                cache[left][right] = 0;
//                return 0;
//            }
//        }
//
//        int m = 0;
//        if (s.charAt(right) == '(') {
//            m = longestValidParentheses(s, cache, left, right-1);
//        } else {
//            m = longestValidParentheses(s, cache, left, right-1);
//            for (int i = left; i < right; i++) {
//                if (s.charAt(i) == '(') {
//                    m = Math.max(m,
//                        longestValidParentheses(s, cache, left, i-1) + longestValidParentheses(s,
//                            cache,
//                            i + 1, right-1) + 2);
//                }
//            }
//        }
//        cache[left][right] = m;
//        return m;
//    }
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int[] cache = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cache[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || stack.size() == 0) {
                stack.push(ch);
                index.push(i);
            } else {
                if (stack.peek() == '(') {
                    int left = index.pop();
                    stack.pop();
                    cache[left] = i;
                } else {
                    stack.push(ch);
                    index.push(i);
                }
            }
        }
        int m = 0;
        int count = 0;
        for (int i = 0; i < cache.length; ) {
            if (cache[i] == -1) {
                i++;
                m = Math.max(m, count);
                count = 0;
                continue;
            } else {
                count += cache[i] - i + 1;
                i = cache[i] + 1;
                m = Math.max(m, count);
            }
        }
        return m;
    }
}
