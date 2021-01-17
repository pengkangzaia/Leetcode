package daily;

/**
 * @FileName: No547.java
 * @Description: 省份数量
 * @Author: camille
 * @Date: 2021/1/7 8:20
 */
public class No547 {


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] cities = new int[n];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    cities[j] = cities[i];
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        /*No547 no547 = new No547();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int ans = no547.findCircleNum(isConnected);
        System.out.println(ans);*/
        for (int i = -100; i < 100; i++) {
            System.out.println("i=" + i + "结果=" + i % (-2));
        }
    }

}
