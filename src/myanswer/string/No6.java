package myanswer.string;

import java.util.ArrayList;

public class No6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2) {
            return s;
        }
        ArrayList<StringBuilder> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            int k = i % (2 * numRows - 2);
            if (k <= (numRows - 1)) {
                lists.get(k).append(s.charAt(i));
            } else {
                lists.get(2 * numRows - 2 - k).append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        /*for (ArrayList<Character> list : lists) {
            res = res + list.toString();
        }*/
        for (StringBuilder list : lists) {
            res.append(list.toString());
        }
        return res.toString();

    }

    public String convert2(String s, int numRows) {
        // 在转折点使用 flag
        if (s == null || s.length() == 0 || numRows < 2) {
            return s;
        }

        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int i = 0;//行号
        int flag = -1; //转折符号位
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if(i == 0 || i==(numRows-1)) {
                flag = -1 * flag;
            }
            i = i + flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder.toString());
        }
        return res.toString();

    }

    public static void main(String[] args) {
        No6 no6 = new No6();
        String ans1 = no6.convert("LEETCODEISHIRING", 4);
        String ans2 = no6.convert2("LEETCODEISHIRING", 4);
        System.out.println(ans1);
        System.out.println(ans2);
    }

}
