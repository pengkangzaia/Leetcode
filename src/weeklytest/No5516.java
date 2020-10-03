package weeklytest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @FileName: No5516.java
 * @Description: No5516.java类说明
 * @Author: camille
 * @Date: 2020/10/3 22:40
 */
public class No5516 {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        // 一个小时之内
        int n = keyName.length;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(keyName[i])) {
                List<String> strings = map.get(keyName[i]);
                strings.add(keyTime[i]);
                map.put(keyName[i], strings);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(keyTime[i]);
                map.put(keyName[i], temp);
            }
        }

        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            List<String> strings = map.get(s);
            if (strings.size() < 3) {
                continue;
            }
            Collections.sort(strings);
            for (int i = 0; i < strings.size() - 2; i++) {
                long interval = 0;
                try {
                    interval = sdf.parse(strings.get(i+2)).getTime() - sdf.parse(strings.get(i)).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (interval <= 1000 * 60 * 60) {
                    res.add(s);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) throws ParseException {
        No5516 no5516 = new No5516();
        String[] keyNames = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTimes = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        List<String> strings = no5516.alertNames(keyNames, keyTimes);
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
