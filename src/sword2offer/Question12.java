package sword2offer;

public class Question12 {

    private int pathLength = 0;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0
                || word == null || word.length() == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols]; // 默认false
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = hasPath(board, i, j, rows, cols, word, visited, pathLength);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(
            char[][] board, int i, int j, int rows, int cols,
            String word, boolean[][] visited, int pathLength) {
        if (pathLength == word.length() - 1) {
            return true;
        }
        boolean flag = false;
        if (i >= 0 && i < rows && j >= 0 && j < cols
                && board[i][j] == word.charAt(pathLength) && !visited[i][j]) {
            pathLength++;
            visited[i][j] = true;
            flag = hasPath(board, i + 1, j, rows, cols, word, visited, pathLength) ||
                    hasPath(board, i - 1, j, rows, cols, word, visited, pathLength) ||
                    hasPath(board, i, j + 1, rows, cols, word, visited, pathLength) ||
                    hasPath(board, i, j - 1, rows, cols, word, visited, pathLength);
            if (!flag) {
                pathLength--;
                visited[i][j] = false;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        char[][] board = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        String word = "acj";
        boolean ans = question12.exist(board, word);
        System.out.println(ans);
    }

}
