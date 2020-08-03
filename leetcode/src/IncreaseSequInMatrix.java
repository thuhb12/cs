public class IncreaseSequInMatrix {
    public static void main(String[] args) {
        IncreaseSequInMatrix increaseSequInMatrix = new IncreaseSequInMatrix();
        int[][] s= {
                    {9, 9, 4},
                    {6, 6, 8},
                    {2, 1, 1}
                    };
        System.out.println(increaseSequInMatrix.longestIncreasingPath(s));
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (cache[i][j] == 0) {
                    increaseSequ(matrix, cache, i, j);
                }
            }
        }
        int m = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                m = Math.max(m, cache[i][j]);
            }
        }
        return m;
    }

    private int increaseSequ(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int m = 0;
        if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
            m = Math.max(m, increaseSequ(matrix, cache, i-1, j));
        }
        if (i < matrix.length-1 && matrix[i+1][j] > matrix[i][j]) {
            m = Math.max(m, increaseSequ(matrix, cache, i+1, j));
        }
        if (j < matrix[0].length-1 && matrix[i][j+1] > matrix[i][j]) {
            m = Math.max(m, increaseSequ(matrix, cache, i, j+1));
        }
        if (j > 0 && matrix[i][j-1] > matrix[i][j]) {
            m = Math.max(m, increaseSequ(matrix, cache, i, j-1));
        }
        cache[i][j] = m + 1;
        return m + 1;
    }
}
