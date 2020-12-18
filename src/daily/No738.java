package daily;

/**
 * @FileName: No738.java
 * @Description: 单调递增的数字
 * @Author: admin
 * @Date: 2020/12/15 9:01
 */
public class No738 {

    public int monotoneIncreasingDigits(int N) {
        if (N == 0) {
            return 0;
        }
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        int index = chars.length;
        while (!isIncreasing(chars)) {
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] - chars[i + 1] > 0) {
                    // 当此位减一了，可能就不满足上一位的递增关系了
                    chars[i] = (char) ((int) chars[i] - 1);
                    index = i;
                    break;
                }
            }
            for (int i = index + 1; i < chars.length; i++) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    private boolean isIncreasing(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] - chars[i + 1] > 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        No738 no738 = new No738();
        int ans = no738.monotoneIncreasingDigits(332);
        System.out.println(ans);
    }

}
