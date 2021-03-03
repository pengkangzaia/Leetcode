package mock;

/**
 * @FileName: FindGoodStrings.java
 * @Description: FindGoodStrings.java类说明
 * @Author: admin
 * @Date: 2021/3/1 14:30
 */
public class FindGoodStrings {


    /**
     * 给你两个长度为 n 的字符串 s1 和 s2 ，以及一个字符串 evil 。请你返回 好字符串 的数目。
     * 好字符串 的定义为：它的长度为 n ，字典序大于等于 s1 ，字典序小于等于 s2 ，且不包含 evil 为子字符串。
     * 由于答案可能很大，请你返回答案对 10^9 + 7 取余的结果。
     */


    // 太难了，放弃
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        // 求一个字符串，长度为n。
        // 字典序小于等于s2的字符串个数 - 字典序小于等于s1的字符串个数
        if (s2.compareTo(s1) < 0) {
            return 0;
        }


        return -1;

    }


}
