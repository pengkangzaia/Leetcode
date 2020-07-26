package MyAnswer.string;

public class No151 {

    public String reverseWords(String s) {
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
        // 这种写法不能处理多个空格的情况
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = strings.length - 1;
        while (i <= j) {
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            i++;
            j--;
        }
        for (int k = 0; k < strings.length; k++) {
            // 加一个判断，去除多个空格的情况
            if(!strings[k].equals("")){
                sb.append(strings[k]+" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        No151 no151 = new No151();
        String ans = no151.reverseWords(" ");
        System.out.println(ans);
    }


}
