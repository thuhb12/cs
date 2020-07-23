/*
    392. Is Subsequence
*/
public class Subsequence {
    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(subsequence.isSubsequence(s, t));
    }
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean find = false;
            for (int k = j; k < t.length(); k++) {
                if (t.charAt(k) == ch) {
                    j = k + 1;
                    find = true;
                    break;
                }
            }
            if (!find) {
                return false;
            }
        }
        return true;
    }
}
