package myanswer.string;

/**
 * @FileName: No394.java
 * @Description: 字符串解码
 * @Author: admin
 * @Date: 2020/10/29 16:34
 */
public class No394 {

    // 输入：s = "3[a]2[bc]"
    // 输出："aaabcbc"

    private final StringBuilder sb = new StringBuilder();

    public String decodeString(String s) {
        // 遇到a-z直接加
        // 遇到数字，进入函数处理
        char[] chars = s.toCharArray();
        StringBuilder tem = new StringBuilder();
        boolean repeat = false;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                sb.append(chars[i]);
                i++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                int repeatCnt = chars[i] - '0';
                // i+1之后，]字符之前
                i = repeat(repeatCnt, chars, i + 1);
            }
        }
        return sb.toString();
    }

    private int repeat(int repeatCnt, char[] chars, int s) {
        int e = s;
        StringBuilder tem = new StringBuilder();
        for (int i = s + 1; i < chars.length; i++) {
            if (chars[i] == ']') {
                e = i;
                break;
            } else {
                tem.append(chars[i]);
            }
        }
        while (repeatCnt != 0) {
            sb.append(tem);
            repeatCnt--;
        }
        return e + 1;
    }

    public static void main(String[] args) {
        No394 no394 = new No394();
        String ans = no394.decodeString("ciuehcw3[wudi]");
        System.out.println(ans);
    }


}
