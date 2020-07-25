package MyAnswer.string;

import java.util.Arrays;

public class No14 {

    public String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        if(strs.length == 0) {
            return "";
        } else {
            for(int i = 0; i < strs.length; i++) {
                if(strs[i] == null && strs[i].length() == 0) {
                    return "";
                }
            }
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int n = strs[0].length();
        int m = strs[strs.length-1].length();
        for (int i = 0; i < Math.min(n,m); i++) {
            if (strs[0].charAt(i) == strs[strs.length-1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
