package weeklytest;

import java.util.List;

/**
 * @FileName: No5689.java
 * @Description: No5689.java类说明
 * @Author: camille
 * @Date: 2021/2/28 10:31
 */
public class No5689 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type")) {
                if (ruleValue.equals(item.get(0))) {
                    res++;
                }
            } else if (ruleKey.equals("color")) {
                if (ruleValue.equals(item.get(1))) {
                    res++;
                }
            } else {
                if (ruleValue.equals(item.get(2))) {
                    res++;
                }
            }
        }
        return res;
    }

}
