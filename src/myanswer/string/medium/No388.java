package myanswer.string.medium;


/**
 * @FileName: No388.java
 * @Description: 文件的最长绝对路径
 * @Author: camille
 * @Date: 2021/3/3 22:15
 */
public class No388 {

    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];    //从1开始，第0层就是0

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;    // 计算当前在第几层（从第一层开始，没有\t就是第一层）
            int len = s.length() - (level - 1);     // 计算当前这一行的长度
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;  //是目录，要+1，目录有个/的
            }
        }

        return res;
    }

    /*作者：jerry_nju
    链接：https://leetcode-cn.com/problems/longest-absolute-file-path/solution/javajian-ji-de-zi-fu-chuan-chu-li-by-jerry_nju/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        No388 no388 = new No388();
        int ans = no388.lengthLongestPath("dir\n\tsubdir1\n\t\tsubdir2\n\t\t\tfile.ext");
        System.out.println(ans);
    }



}
