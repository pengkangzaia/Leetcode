package weeklytest;

/**
 * @FileName: No1689.java
 * @Description: No1689.java类说明
 * @Author: admin
 * @Date: 2020/12/18 17:19
 */
public class No1689 {

    public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int curr = chars[i] - '0';
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        No1689 no1689 = new No1689();
        int ans = no1689.minPartitions("200500000000550");
        System.out.println(ans);
    }

}
