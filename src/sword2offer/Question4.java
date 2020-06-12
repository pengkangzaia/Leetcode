package sword2offer;

public class Question4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        return findNumber(matrix, row, col, target);
    }

    private boolean findNumber(int[][] matrix, int row, int col, int target) {

        if (row >= matrix.length || col < 0) {
            return false;
        }
        if (target == matrix[row][col]) {
            return true;
        } else if (target < matrix[row][col]) {
            return findNumber(matrix, row, col - 1, target);
        } else {
            return findNumber(matrix, row + 1, col, target);
        }

    }

}
