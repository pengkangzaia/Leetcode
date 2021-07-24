//package weeklytest;
//
///**
// * @author 彭康
// * @create 2021-06-13 10:43
// **/
//public class No5786 {
//
//    public int maximumRemovals(String s, String p, int[] removable) {
//        if (isSubsequence(p, s)) {
//            for (int i = 0; i < removable.length; i++) {
//                s = remove(s, removable[i]);
//                if (!isSubsequence(p, s)) {
//                    return i;
//                }
//            }
//            return removable.length;
//        } else {
//            return 0;
//        }
//
//    }
//
//    /**
//     *
//     * @param s 子序列
//     * @param t 原序列
//     * @return
//     */
//    public boolean isSubsequence(StringBuilder s, StringBuilder t) {
//        int index = -1;
//        for (char c : s.toCharArray()) {
//            index = t.indexOf(c, index + 1);
//            if (index == -1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public String remove(String s, int num) {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder stringBuilder = sb.deleteCharAt(num);
//        return stringBuilder.toString();
//    }
//
//
//
//}
