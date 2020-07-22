/*
647. Palindromic Substrings
 */
public class CountSubString {
    public static void main(String[] args) {
        CountSubString countSubString = new CountSubString();
        String s = "aaa";
        System.out.println(countSubString.countSubstrings(s));
    }
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countSubstrings(s, i);
            count += countSubstrings(s, i, i+1);
        }
        return count;
    }

    private int countSubstrings(String s, int left, int right) {
        int count = 0;
        for (int i = left, j = right; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private int countSubstrings(String s, int mid) {
        int count = 0;
        for (int i = mid, j = mid; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
