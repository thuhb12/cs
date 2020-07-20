/*
115. Distinct Subsequences
 */

public class NumTinStringS {
    public static void main(String[] args) {
        NumTinStringS numTinStringS = new NumTinStringS();
        String s = "babgbag";
        String t = "bag";
        System.out.println(numTinStringS.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int[][] cache = new int[s.length()][t.length()];
        if (s.charAt(s.length()-1) == t.charAt(t.length()-1)) {
            cache[s.length()-1][t.length()-1] = 1;
        }
        for (int i = s.length()-2; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(t.length()-1)) {
                cache[i][t.length()-1] = cache[i+1][t.length()-1] + 1;
            } else {
                cache[i][t.length()-1] = cache[i+1][t.length()-1];
            }
        }

        for (int i = s.length()-2; i >= 0; i--) {
            for (int j = t.length()-2; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    int m = 0;
                    m +=cache[i+1][j+1];
                    m += cache[i+1][j];
                    cache[i][j] = m;
                } else  {
                    cache[i][j] = cache[i+1][j];
                }
            }
        }
        return cache[0][0];
    }
}
