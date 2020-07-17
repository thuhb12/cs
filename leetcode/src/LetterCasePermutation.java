import java.util.ArrayList;
import java.util.List;
/*
784. Letter Case Permutation
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation("a12B"));
    }

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        list.add(S);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                continue;
            }
            List<String> current = new ArrayList<>();
            for (String s : list) {
                StringBuilder copy = new StringBuilder(s);
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    String ch = s.charAt(i) + "";

                    copy.replace(i,i+1, ch.toLowerCase());
                } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    String ch = s.charAt(i) + "";
                    copy.replace(i,i+1, ch.toUpperCase());
                }
                current.add(copy.toString());
            }
            list.addAll(current);
        }
        return list;
    }
}
