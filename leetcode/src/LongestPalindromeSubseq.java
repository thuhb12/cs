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
//        int[][] cache = new int[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            cache[i][i] = 1;
//            for (int j = i + 1; j < ; left++) {
//                if (s.charAt(left) == s.charAt(i)) {
//                    int plus = 2;
//                    if (left == i) {
//                        plus = 1;
//                    }
//                    cache[i] = getInterval(cache, left+1, i) + plus;
//                    break;
//                }
//            }
//        }
//        return getInterval(cache, 0, s.length()-1);
        return 0;
    }

    private int getInterval(int[] cache, int left, int right) {
        if (left > right) {
            return 0;
        }
        int m = 0;
        for (int i = left; i <= right; i++) {
            m = Math.max(m, cache[i]);
        }
        return m;
    }
}
