package myanswer.string;

public class No58 {

    public int lengthOfLastWord(String s) {
        // LeetCode解法
//        int end = s.length() - 1;
//        while(end >= 0 && s.charAt(end) == ' ') end--;
//        if(end < 0) return 0;
//        int start = end;
//        while(start >= 0 && s.charAt(start) != ' ') start--;
//        return end - start;

//        if(s==null||s.length()==0){
//            return 0;
//        }
//
//        int index = s.length()-1;
//        char[] chars = s.toCharArray();
//        // 过滤后边的空格
//        while(index>=0 && chars[index]==' '){
//            index--;
//        }
//        int start=index,e=index;
//        for(int i=index; i>=0; i--){
//            if(chars[i]!=' '){
//                e--;
//            } else {
//                break;
//            }
//        }
//        return start-e;
        int end = s.length()-1;
        while (end>=0 && s.charAt(end)==' '){
            end--;
        }
        int start = end;
        while(start>=0 && s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }



    public static void main(String[] args) {
        No58 no58 = new No58();
        int ans = no58.lengthOfLastWord("scw ");
        System.out.println(ans);
    }

    public int lengthOfLastWord1(String s) {
        char[] chars = s.toCharArray();
        int nums = 0, right = chars.length - 1;
        while (right >= 0) {
            if (chars[right] != ' ') {
                break;
            }
            right--;
        }
        while (right >= 0) {
            if (chars[right] != ' ') {
                right--;
                nums++;
            } else {
                break;
            }
        }
        return nums;
    }

}
