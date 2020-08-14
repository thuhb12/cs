/*
516. Longest Palindromic Subsequence
 */

public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int[][] cache = new int[s.length()][s.length()];
        return getInterval(s, cache, 0, s.length()-1);
    }

    private int getInterval(String s, int[][] cache, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            cache[left][right] = 1;
            return 1;
        }
        if (cache[left][right] != 0) {
            return cache[left][right];
        }
        int m = 0;
        if (s.charAt(left) == s.charAt(right)) {
            int inner = getInterval(s, cache, left + 1, right - 1) + 2;
            m = Math.max(m, inner);
        }
        int l = getInterval(s, cache, left, right-1);
        int r = getInterval(s, cache, left+1, right);
        m = Math.max(m, Math.max(l, r));
        cache[left][right] = m;
        return m;
    }
}
