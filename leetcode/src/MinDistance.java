/*
583. Delete Operation for Two Strings
 */
public class MinDistance {
    public static void main(String[] args) {
        String s = "sea";
        String t = "eat";
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance(s, t));
    }

    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            cache[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            cache[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int m ;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    m = Math.min(cache[i-1][j-1], Math.min(cache[i-1][j]+1, cache[i][j-1]+1));
                } else {
                    m = Math.min(cache[i-1][j-1] + 2, Math.min(cache[i-1][j]+1, cache[i][j-1]+1));
                }
                cache[i][j] = m;
            }
        }
        return cache[word1.length()][word2.length()];
    }
}
