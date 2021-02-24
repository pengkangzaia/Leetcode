package mock;

import java.util.TreeMap;

/**
 * @FileName: MyCalendarTwo.java
 * @Description: MyCalendarTwo.java类说明
 * @Author: camille
 * @Date: 2021/2/24 23:56
 */
public class MyCalendarTwo {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        // 尝试添加至日程中
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        // 记录活跃的日程数
        int active = 0;

        for (int d : calendar.values()) {
            // 以时间线统计日程，对每一个时间节点的key，value对应以该时间节点开头（+1）或结尾（-1）的日程数量
            active += d;

            // 中途活跃日程>=3时，返回 false
            if (active >= 3) {

                // 恢复现场
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);

                // remove this part, it can passes. but this will only costs more spaces.
                if (calendar.get(start) == 0)
                    calendar.remove(start);

                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        MyCalendarTwo two = new MyCalendarTwo();
        two.book(10,20);
        two.book(10,40);
        two.book(5,15);
    }


}
