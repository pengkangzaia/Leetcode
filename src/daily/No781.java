package daily;

/**
 * @FileName: No781.java
 * @Description: No781.java类说明
 * @Author: camille
 * @Date: 2021/4/4 16:18
 */
public class No781 {

    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        int[] num = new int[1000];
        for (int i = 0; i < answers.length; i++) {
            num[answers[i]]++;
        }

        int res = num[0];
        for (int i = 1; i < 1000; i++) {
            int currFreq = num[i];
            if (currFreq % (i + 1) == 0) {
                res += (currFreq / (i + 1)) * (i + 1);
            } else {
                res += (currFreq / (i + 1) + 1) * (i + 1);
            }
        }
        return res;
    }


}
