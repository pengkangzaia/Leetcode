package datastructure1.sort;

// 基数排序

/**
 * 将数字切割成个、十、百、千位放入到不同的桶子里，放一次就按桶子顺序回收一次，
 * 直至最大位数的数字放完～那么该数组就有序了
 *
 *
 * 从低位向高位排序是因为：
 * 22 31 13 从小到大排序
 * 从高位 第一次：13 22 31，第二位：31 22 13 错了
 * 从低位 第一次：31 22 13，第二次：13 22 31 对的
 *
 * 从高位会更加麻烦，需要给高位再分小组，对各个小组分别进行排序
 */
public class RadixSort {
    public static void radixSort(int[] arrays) {
        int max = findMax(arrays, 0, arrays.length - 1);
        //需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] buckets = new int[arrays.length][10];
            //获取每一位数字(个、十、百、千位...分配到桶子里)
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                //将其放入桶子里
                buckets[j][num] = arrays[j];
            }
            //回收桶子里的元素
            int k = 0;
            //有10个桶子
            for (int j = 0; j < 10; j++) {
                //对每个桶子里的元素进行回收
                for (int l = 0; l < arrays.length ; l++) {
                    //如果桶子里面有元素就回收(数据初始化会为0)
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    public static int findMax(int[] arrays, int L, int R) {
        //如果该数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R) {
            return arrays[L];
        } else {
            int a = arrays[L];
            int b = findMax(arrays, L + 1, R);//找出整体的最大值
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }
}
