/*
520. Detect Capital
 */
public class DetectCapital {
    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        String s = "googleG";
        System.out.println(detectCapital.detectCapitalUse(s));
    }

    public boolean detectCapitalUse(String word) {
        int count = 0;
        int start = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
                if (start == -1) {
                    start = i;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        if (count == word.length()) {
            return true;
        }
        if (count == 1 && start == 0) {
            return true;
        }
        return false;
    }
}
