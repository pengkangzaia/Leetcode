package bishi;

import java.util.LinkedList;

public class PathTest {

    /**
     * 输入："/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     * 阿白
     * 输入："/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级
     * 阿白
     * 输入："/a/./b/../../c/"
     * 输出："/c"
     */
    public static void main(String[] args) {
        PathTest pathTest = new PathTest();
        String path = pathTest.findPath1("/a/./b/../../../../c/");
        System.out.println(path);
    }

    public String findPath(String s) {
        String[] strings = s.split("/");
        LinkedList<String> paths = new LinkedList<>();
        String res = "/";
        for (String string : strings) {
            if (string.equals(".") || string.equals("")) {
                continue;
            } else if (string.equals("..")) {
                if (paths.size() > 0) {
                    paths.removeLast();
                }
            } else {
                paths.add(string);
            }
        }
        if (paths.size() == 0) {
            return res;
        }
        for (String path : paths) {
            res += path + "/";
        }
        return res.substring(0, res.length()-1);
    }

    public String findPath1(String s) {
        String[] strings = s.split("/");
        LinkedList<String> paths = new LinkedList<>();
        StringBuilder res = new StringBuilder("/");
        for (String string : strings) {
            if (string.equals(".") || string.equals("")) {
                continue;
            } else if (string.equals("..")) {
                if (paths.size() > 0) {
                    paths.removeLast();
                }
            } else {
                paths.add(string);
            }
        }
        if (paths.size() == 0) {
            return res.toString();
        }
        for (String path : paths) {
            res.append(path);
            res.append("/");
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }


}
