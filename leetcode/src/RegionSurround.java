/*
130. Surrounded Regions
 */
public class RegionSurround {
    public static void main(String[] args) {
        RegionSurround regionSurround = new RegionSurround();
        char[][] board = {{'O','X','O'},{'X','O','X'},{'O','X','O'}};
        regionSurround.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) {
        if (board.length <= 0 || board[0].length <= 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        int[][] marked = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (marked[i][0] == 0 && board[i][0] == 'O') {
                dfs(board, visited, marked, i, 0);
            }
            if (marked[i][col-1] == 0 && board[i][col-1] == 'O') {
                dfs(board, visited, marked, i, col-1);
            }
        }
        for (int j = 0; j < col; j++) {
            if (marked[0][j] == 0 && board[0][j] == 'O') {
                dfs(board, visited, marked, 0, j);
            }
            if (marked[row-1][j] == 0 && board[row-1][j] == 'O') {
                dfs(board, visited, marked, row-1, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = 'X';
                if (marked[i][j] == 1) {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] visited, int[][] marked, int i, int j) {
        visited[i][j] = 1;
        marked[i][j] = 1;
        if (i > 1 && board[i-1][j] == 'O' && visited[i-1][j] == 0) {
           dfs(board, visited, marked, i-1, j);
        }
        if (j > 1 && board[i][j-1] == 'O' && visited[i][j-1] == 0) {
            dfs(board, visited, marked, i, j-1);
        }
        if (i < board.length-1 && board[i+1][j] == 'O' && visited[i+1][j] == 0) {
            dfs(board, visited, marked, i+1, j);
        }
        if (j < board[0].length-1 && board[i][j+1] == 'O' && visited[i][j+1] == 0) {
            dfs(board, visited, marked, i, j+1);
        }
        visited[i][j] = 0;
    }
}
