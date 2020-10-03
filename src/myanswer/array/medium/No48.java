package myanswer.array.medium;

public class No48 {

    public void rotate(int[][] matrix) {
        int temp = -1;
        for (int s = 0, e = matrix.length - 1; s < e; s++, e--) {
            for (int start = s, end = e; start < e; start++, end--) {
                temp = matrix[s][start];
                matrix[s][start] = matrix[end][s];
                matrix[end][s] = matrix[e][end];
                matrix[e][end] = matrix[start][e];
                matrix[start][e] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        No48 no48 = new No48();
        no48.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
