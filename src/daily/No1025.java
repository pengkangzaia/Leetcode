package daily;

public class No1025 {

    // 奇数*奇数=奇数
    // 奇数-奇数=偶数
    // 如果 N 为奇数，那么 N - x 一定是偶数
    // 只要哪个要操作时， N=2，哪个就会赢。
    // 所以，如果初始值 N 为偶数，那么每次减一，另一个人要处理的每次就是奇数
    // 奇数处理过后，一定是偶数。
    // 所以 N=2 一定会被最开始的那个用户轮到。
    // 综上，只要 N为偶数，则 alice 稳赢
    // N为奇数，alice 处理好，一定是偶数。那么 bob 稳赢
    public boolean divisionGame(int N) {
        return N % 2 == 0;
    }

}
