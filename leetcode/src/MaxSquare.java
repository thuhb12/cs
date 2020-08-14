/*
221. Maximal Square
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
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
                    if (matrix[i][j] == '0') {
                        cache[i][j] = 0;
                    } else {
                        cache[i][j] = maxCacheSquare(matrix, i, j, cache);
                    }
                }
                m = Math.max(m, cache[i][j]);
            }
        }
        return m * m;
    }

    private int maxCacheSquare(char[][] matrix, int i, int j, int[][] cache) {
        if (i < 0 || i >= cache.length || j >= cache[0].length || j < 0) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int m = Math.min(maxCacheSquare(matrix, i-1, j-1, cache), maxCacheSquare(matrix, i-1, j, cache));
        m = Math.min(m, maxCacheSquare(matrix, i, j-1, cache));
        cache[i][j] = m + 1;
        return m + 1;
    }
}
