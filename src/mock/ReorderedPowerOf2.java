package mock;

/**
 * @FileName: ReorderedPowerOf2.java
 * @Description: ReorderedPowerOf2.java类说明
 * @Author: camille
 * @Date: 2021/3/2 22:04
 */
public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int num) {
        // 将数字转化为字符串
        int[] digts = new int[10];
        int idx = 0;
        while (num > 0) {
            digts[idx++] = num % 10;
            num /= 10;
        }
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[idx];
        return dfs(digts, visited, path, idx);
    }

    private boolean dfs(int[] digts, boolean[] visited, StringBuilder path, int idx) {
        if (path.length() == idx) {
            int currNum = Integer.parseInt(path.toString());
            return (currNum & (currNum - 1)) == 0;
        }
        for (int i = 0; i < idx; i++) {
            // 前导零则直接不行
            if (path.length() == 0 && digts[i] == 0) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                path.append(digts[i]);
                if (dfs(digts, visited, path, idx)) {
                    return true;
                }
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReorderedPowerOf2 solution = new ReorderedPowerOf2();
        for (int i = 1; i < 50; i++) {
            System.out.println(i + "    " + solution.reorderedPowerOf2(i));
        }
    }


}
