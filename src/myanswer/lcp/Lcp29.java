package myanswer.lcp;

/**
 * @author 彭康
 * @create 2021-08-08 21:17
 **/
public class Lcp29 {


    public static void main(String[] args) {
        Lcp29 lcp29 = new Lcp29();
        int ans = lcp29.orchestraLayout(3, 0, 2);
        System.out.println(ans);
    }


    public int orchestraLayout(int num, int xPos, int yPos) {
        int[][] array = new int[num][num];
        int up = 0;
        int down = num - 1;
        int left = 0;
        int right = num - 1;
        int i = 0;
        int j = 0;
        int currNum = 0;
        while (true) {
            while (j <= right) {
                array[i][j++] = (currNum++) % 9 + 1;
            }
            j--; // 还原
            up++; // 第i行结束
            i++;
            if (up > down) { break; }

            while (i <= down) {
                array[i++][j] = (currNum++) % 9 + 1;
            }
            i--;
            right--;
            j--;
            if (left > right) { break; }

            while (j >= left) {
                array[i][j--] = (currNum++) % 9 + 1;
            }
            j++;
            down--;
            i--;
            if (up > down) { break; }

            while (i >= up) {
                array[i--][j] = (currNum++) % 9 + 1;
            }
            i++;
            left++;
            j++;
            if (left > right) { break; }
        }
        return array[xPos][yPos];
    }


}
