package myanswer.interview;


/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TenPointZeroOne {
    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge(a,3,b,3);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void merge(int[] a, int m, int[] b, int n) {
        if(a.length==0||b.length==0){
            return;
        }
        int indexAll = m + n - 1;
        int indexA = m-1;
        int indexB = n-1;
        while (indexA!=-1 && indexB!=-1){
            if(a[indexA]<=b[indexB]){
                a[indexAll--]=b[indexB--];
            }else {
                a[indexAll--]=a[indexA--];
            }
        }
        if(indexA==-1){
            //遍历剩下的b放入a中
            while (indexB!=-1){
                a[indexAll--]=b[indexB--];
            }
        }
    }

}
