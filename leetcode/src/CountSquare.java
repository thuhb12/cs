/*
1277
 */
public class CountSquare {
    public int countSquares(int[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        int m = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (cache[i][j] == -1) {
                    if (matrix[i][j] == 0) {
                        cache[i][j] = 0;
                    } else {
                        cache[i][j] = maxCacheSquare(i, j, cache);
                    }
                }
                m += cache[i][j];
            }
        }
        return m;
    }

    private int maxCacheSquare(int i, int j, int[][] cache) {
        if (i < 0 || i >= cache.length || j >= cache[0].length || j < 0) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int m = Math.min(maxCacheSquare(i-1, j-1, cache), maxCacheSquare(i-1, j, cache));
        m = Math.min(m, maxCacheSquare(i, j-1, cache));
        cache[i][j] = m + 1;
        return m + 1;
    }
}
