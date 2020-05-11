package sword2offer;

public class Question29 {

    public static void main(String[] args) {
        Question29 question29 = new Question29();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[] ans = question29.spiralOrder(matrix);
        System.out.println("================");
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] spiralOrder(int[][] matrix) {

        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int[] ans = new int[(d + 1) * (r + 1)];
        int index = 0;

        while (true) {
            // 打印上边界
            for (int i = l; i <= r; i++) {
                ans[index++] = matrix[u][i];
            }
            u++;
            // 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。!!!
            // 判断条件是重点！！！
            // 如果下边界大于上边界，或者左边界大于右边界，说明接下来要打印的行不存在了
            if (u > d) break;
            // 打印右边界
            for (int i = u; i <= d; i++) {
                ans[index++] = matrix[i][r];
            }
            r--;
            if (l > r) break;
            // 打印下边界
            for (int i = r; i >= l; i--) {
                ans[index++] = matrix[d][i];
            }
            d--;
            if (u > d) break;
            // 打印左边界
            for (int i = d; i >= u; i--) {
                ans[index++] = matrix[i][l];
            }
            l++;
            if (l > r) break;
        }
        //ans[index] = matrix[u][r];

        return ans;
    }

}
