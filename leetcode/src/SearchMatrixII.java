/*
74. Search a 2D Matrix
 */
public class SearchMatrixII {

    public static void main(String[] args) {
        SearchMatrixII searchMatrix = new SearchMatrixII();
        int[][] matrix = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(searchMatrix.searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        for (int i = 0; i < matrix.length;) {
            if (matrix[i][matrix[0].length-1] == target) {
                return true;
            } else if (matrix[i][matrix[0].length-1] > target) {
                return binarySearch(matrix[i], target, 0, matrix[i].length-1);
            } else {
                i++;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target, int i, int j) {
        int left = i;
        int right = j;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
