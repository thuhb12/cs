/*
921. Minimum Add to Make Parentheses Valid
 */
public class MinAddToValid {
    public static void main(String[] args) {
        MinAddToValid minAddToValid = new MinAddToValid();
        System.out.println(minAddToValid.minAddToMakeValid("()))"));
    }
    public int minAddToMakeValid(String S) {
        int[][] cache = new int[S.length()][S.length()];
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return minAdd(S, cache, 0, S.length()-1);
    }

    private int minAdd(String s, int[][] cache, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (right >= s.length()) {
            return 0;
        }
        if (cache[left][right] != -1) {
            return cache[left][right];
        }
        if (left == right) {
            cache[left][right] = 1;
            return 1;
        }
        if (left + 1 == right && s.substring(left, right+1).equals("()")) {
            cache[left][right] = 0;
            return 0;
        }
        if (s.charAt(right) == '(') {
            cache[left][right] = minAdd(s, cache, left, right-1) + 1;
            return cache[left][right];
        } else {
            int m = right - left + 1;
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == '(') {
                    m = Math.min(m, minAdd(s, cache, left, i-1) + minAdd(s, cache, i+1, right-1));
                }
            }
            cache[left][right] = m;
            return m;
        }
    }
}
