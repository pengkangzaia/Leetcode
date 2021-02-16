package mock;

/**
 * @FileName: FindPoisonedDuration.java
 * @Description: FindPoisonedDuration.java类说明
 * @Author: admin
 * @Date: 2021/2/16 22:03
 */
public class FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int maxReach = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] <= maxReach) {
                res -= maxReach - timeSeries[i];
            }
            res += duration;
            maxReach = timeSeries[i] + duration;
        }
        return res;
    }


}
