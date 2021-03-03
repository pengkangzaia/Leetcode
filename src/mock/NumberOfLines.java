package mock;

/**
 * @FileName: NumberOfLines.java
 * @Description: NumberOfLines.java类说明
 * @Author: admin
 * @Date: 2021/3/1 14:02
 */
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int currLine = 1, currSize = 0;
        for (int i = 0; i < chars.length; i++) {
            if (currSize + widths[chars[i] - 'a'] <= 100) {
                currSize += widths[chars[i] - 'a'];
            } else {
                currLine++;
                currSize = widths[chars[i] - 'a'];
            }
        }
        return new int[] {currLine, currSize};
    }

    public static void main(String[] args) {
        NumberOfLines o = new NumberOfLines();
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        // [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
        //"abcdefghijklmnopqrstuvwxyz"
        // [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
        //"bbbcccdddaaa"
        String s = "bbbcccdddaaa";
        int[] ans = o.numberOfLines(widths, s);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }


}
