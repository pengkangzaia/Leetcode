package mock.no29;

/**
 * @FileName: No1.java
 * @Description: No1.java类说明
 * @Author: admin
 * @Date: 2021/1/29 15:55
 */
public class No1 {


    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // z型变换原题
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            builders[index].append(c);
            index += flag;
            if (index % (numRows - 1) == 0) {
                flag = flag * -1;
            }
        }
        for (StringBuilder builder : builders) {
            res.append(builder.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        No1 no1 = new No1();
        String ans = no1.convert("A", 1);
        System.out.println(ans);
    }

}
