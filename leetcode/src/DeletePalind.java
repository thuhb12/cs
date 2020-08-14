/*
1332. Remove Palindromic Subsequences
 */
public class DeletePalind {
    public int removePalindromeSub(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }
        return 2;
    }
}
