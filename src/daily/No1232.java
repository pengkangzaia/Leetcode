package daily;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @FileName: No1232.java
 * @Description: 缀点成线
 * @Author: camille
 * @Date: 2021/1/17 11:32
 */
public class No1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int deltaX = 0;
        int deltaY = 0;
        for (int i = 0; i < coordinates.length - 1; i++) {
            int[] point1 = coordinates[i];
            int[] point2 = coordinates[i + 1];
            if (i == 0) {
                deltaX = point2[0] - point1[0];
                deltaY = point2[1] - point1[1];
            } else {
                int currDeltaX = point2[0] - point1[0];
                int currDeltaY = point2[1] - point1[1];
                if (currDeltaX * deltaY != currDeltaY * deltaX) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1,2},{2,3},{3,5}};
        No1232 no1232 = new No1232();
        boolean ans = no1232.checkStraightLine(coordinates);
        System.out.println(ans);
    }

}
