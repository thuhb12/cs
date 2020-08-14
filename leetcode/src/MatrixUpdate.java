import java.util.ArrayList;
import java.util.List;

/*
542. 01 Matrix
 */
public class MatrixUpdate {
    class Position {
        int i;
        int j;
        int level;
        public Position(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int[][] level = new int[matrix.length][matrix[0].length];
        List<Position> s = new ArrayList<>();
        List<Position> t = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = 1;
                    s.add(new Position(i, j, 0));
                }
            }
        }
        while (s.size() > 0) {
            for (Position position : s) {
                int row = position.i;
                int col = position.j;
                int lev = position.level;
                if (row > 0 && visited[row-1][col] == 0) {
                    visited[row-1][col] = 1;
                    t.add(new Position(row-1, col, lev+1));
                    level[row-1][col] = lev+1;
                }
                if (col > 0 && visited[row][col-1] == 0) {
                    visited[row][col-1] = 1;
                    t.add(new Position(row, col-1, lev+1));
                    level[row][col-1] = lev+1;
                }
                if (row + 1 < matrix.length && visited[row+1][col] == 0) {
                    visited[row+1][col] = 1;
                    t.add(new Position(row+1, col, lev+1));
                    level[row+1][col] = lev+1;
                }
                if (col + 1 < matrix[0].length && visited[row][col+1] == 0) {
                    visited[row][col+1] = 1;
                    t.add(new Position(row, col+1, lev+1));
                    level[row][col+1] = lev+1;
                }
            }
            s = t;
            t = new ArrayList<>();
        }
        return level;
    }
}
