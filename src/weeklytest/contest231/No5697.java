package weeklytest.contest231;

/**
 * @FileName: No5697.java
 * @Description: No5697.java类说明
 * @Author: admin
 * @Date: 2021/3/7 10:30
 */
public class No5697 {

    // 注意理解题目的意思
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int idx = NextOne(s);
        return idx == n;
    }

    private int NextOne(String s) {
        int n = s.length();
        int idx = 0;
        while (idx < n && s.charAt(idx) == '1') {
            idx++;
        }
        while (idx < n && s.charAt(idx) == '0') {
            idx++;
        }
        return idx;
    }


    public static void main(String[] args) {
        No5697 no5697 = new No5697();
        boolean ans = no5697.checkOnesSegment("1001");
        System.out.println(ans);
    }


}
