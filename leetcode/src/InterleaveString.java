public class InterleaveString {
    public static void main(String[] args) {
        InterleaveString interleaveString = new InterleaveString();
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        System.out.println(interleaveString.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if ("".equals(s1)) {
            return s2.equals(s3);
        }
        if ("".equals(s2)) {
            return s1.equals(s3);
        }
        int[][][] cache = new int[s1.length()][s2.length()][s3.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                for (int k = 0; k < s3.length(); k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return isInterleave(s1, s2, s3, 0, 0, 0, cache);
    }

    private boolean isInterleave(String s1, String s2, String s3, int a, int b, int c, int[][][] cache) {
        if (a < s1.length() && b < s2.length() && c < s3.length()) {
            if (cache[a][b][c] != -1) {
                return cache[a][b][c] == 1;
            }
        }
        if (s3.length() - c != s1.length() - a + s2.length() -b) {
            setCache(a, b, c, cache,0);
            return false;
        }
        if (a >= s1.length()) {
            if (s2.substring(b, s2.length()).equals(s3.substring(c, s3.length()))) {
                setCache(a, b, c, cache,1);
                return true;
            } else {
                return false;
            }
        }
        if (b >= s2.length()) {
            if (s1.substring(a, s1.length()).equals(s3.substring(c, s3.length()))) {
                setCache(a, b, c, cache,1);
                return true;
            } else {
                setCache(a, b, c, cache,0);
                return false;
            }
        }
        if (s1.charAt(a) == s3.charAt(c) && s2.charAt(b) == s3.charAt(c)) {
            if (isInterleave(s1, s2, s3, a+1, b, c+1, cache) ||
                isInterleave(s1, s2, s3, a, b+1, c+1, cache)) {
                setCache(a, b, c, cache,1);
                return true;
            } else {
                setCache(a, b, c, cache,0);
                return false;
            }
        } else if (s1.charAt(a) == s3.charAt(c)) {
            if (isInterleave(s1, s2, s3, a+1, b, c+1, cache)) {
                setCache(a, b, c, cache,1);
                return true;
            } else {
                setCache(a, b, c, cache,0);
                return false;
            }
        } else if (s2.charAt(b) == s3.charAt(c)) {
            if (isInterleave(s1, s2, s3, a, b+1, c+1, cache)) {
                setCache(a, b, c, cache,1);
                return true;
            } else {
                setCache(a, b, c, cache,0);
                return false;
            }
        }
        setCache(a, b, c, cache,0);
        return false;
    }

    private void setCache(int a, int b, int c, int[][][] cache, int p) {
        if (a < cache.length && b < cache[0].length && c < cache[0][0].length) {
            cache[a][b][c] = p;
        }
    }
}
