package mock;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: PondSizes.java
 * @Description: PondSizes.java类说明
 * @Author: admin
 * @Date: 2021/2/15 21:06
 */
public class PondSizes {


    public int[] pondSizes(int[][] land) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    res.add(traverse(land, res, i, j));
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    private int traverse(int[][] land, List<Integer> res, int x, int y) {
        // 边界条件判断
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length) {
            return 0;
        }
        int count = 0;
        if (land[x][y] == 0) {
            land[x][y] =  -1 * res.size() - 1;
            count++;
            count += traverse(land, res, x + 1, y);
            count += traverse(land, res, x - 1, y);
            count += traverse(land, res, x, y + 1);
            count += traverse(land, res, x, y - 1);
            count += traverse(land, res, x + 1, y - 1);
            count += traverse(land, res, x - 1, y - 1);
            count += traverse(land, res, x + 1, y + 1);
            count += traverse(land, res, x - 1, y + 1);
            // 可优化，先判断再选择回溯
        }
        return count;
    }

    public static void main(String[] args) {
        PondSizes pondSizes = new PondSizes();
        int[][] land = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        int[] ans = pondSizes.pondSizes(land);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
