/*
459. Repeated Substring Pattern
 */
public class RepeatedString {
    public boolean repeatedSubstringPattern(String s) {
        int total = s.length() / 2;
        for (int i = 1; i <= total; i++) {
            if (s.length() % i == 0 && check(s, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String s, int len) {
        for (int i = 0; i <= s.length()-1-len; i++) {
            if (s.charAt(i) != s.charAt(i+len)) {
                return false;
            }
        }
        return true;
    }
}
