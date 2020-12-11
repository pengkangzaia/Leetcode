package daily;

/**
 * @FileName: No649.java
 * @Description: Dota2参议院
 * @Author: admin
 * @Date: 2020/12/11 9:50
 */
public class No649 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        char[] chars = senate.toCharArray();
        char res;
        int index = 0;
        while ((res = isFinished(chars, index)) == '@') {
            disableNext(chars, index);
            index = (index + 1) % n; // 更新下一个元素
        }
        return res == 'D' ? "Dire" : "Radiant";
    }

    private void disableNext(char[] chars, int index) {
        int n = chars.length;
        char curr = chars[index];
        if (curr == '#') {
            return; // 当前参议院被禁用了，没有权限禁用别的用户。直接跳过
        }
        int currIndex = index + 1;
        // 只查询一轮
        while (currIndex - index < n && (chars[currIndex % n] == '#' || chars[currIndex % n] == curr)) {
            currIndex++;
        }
        if (currIndex - index < n) {
            chars[currIndex % n] = '#'; //禁用
        }
    }

    private char isFinished(char[] chars, int index) {
        if (index != 0) {
            return '@'; // 只有到第0个位置才能做判断
        }
        int Rcount = 0;
        int Dcount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                Rcount++;
            } else if (chars[i] == 'D') {
                Dcount++;
            }
        }
        if (Rcount == 0 && Dcount > 0) {
            return 'D';
        }
        if (Dcount == 0 && Rcount > 0) {
            return 'R';
        }
        // 未结束标志
        return '@';
    }

    public static void main(String[] args) {
        No649 no649 = new No649();
        String ans = no649.predictPartyVictory("RDRDD");
        System.out.println(ans);
    }


}
