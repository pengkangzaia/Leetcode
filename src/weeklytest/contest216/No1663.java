package weeklytest.contest216;

/**
 * @FileName: No1663.java
 * @Description: No1663.java类说明
 * @Author: admin
 * @Date: 2020/11/25 12:12
 */
public class No1663 {

    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        int index = n - 1;
        while (k >= 26 + index + 1) {
            chars[index] = 'z';
            index--;
            k -= 26;
        }

        if (k > index) {
            chars[index] = (char) (k - index + 'a' - 1);
            index--;
            k = index;
        }
        for (int i = 0; i <= index; i++) {
            chars[i] = 'a';
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        No1663 no1663 = new No1663();
        String ans = no1663.getSmallestString(5, 31);
        System.out.println(ans);
    }


}
