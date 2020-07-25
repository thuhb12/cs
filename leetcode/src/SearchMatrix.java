/*
240. Search a 2D Matrix II
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matrix = {
        {1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };
        System.out.println(searchMatrix.searchMatrix(matrix, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int j = matrix[0].length-1;
        int i = 0;
        for (; i < matrix.length && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
