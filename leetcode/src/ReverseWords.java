import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
151. Reverse Words in a String
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = "the sky is blue";
        System.out.println(reverseWords.reverseWords(s));
    }
    public String reverseWords(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= s.length()) {
                break;
            }
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                String a = get(s, i);
                result.add(a);
                i += a.length();
            }
        }
        if (result.size() == 0) {
            return "";
        }
        Collections.reverse(result);
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < result.size()-1; j++) {
            stringBuilder.append(result.get(j));
            stringBuilder.append(" ");
        }
        stringBuilder.append(result.get(result.size()-1));
        return stringBuilder.toString();
    }

    private String get(String s, int p) {

        int right = p;
        for (; right < s.length(); right++) {
            if (s.charAt(right) == ' ') {
                break;
            }
        }
        return s.substring(p, right);
    }
}
