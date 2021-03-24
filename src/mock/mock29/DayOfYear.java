package mock.mock29;

/**
 * @FileName: DayOfYear.java
 * @Description: DayOfYear.java类说明
 * @Author: admin
 * @Date: 2021/3/24 16:31
 */
public class DayOfYear {

    /**
     * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
     *
     * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，
     * 依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
     *
     *
     *
     * 示例 1：
     *
     * 输入：date = "2019-01-09"
     * 输出：9
     * 示例 2：
     *
     * 输入：date = "2019-02-10"
     * 输出：41
     * 示例 3：
     *
     * 输入：date = "2003-03-01"
     * 输出：60
     * 示例 4：
     *
     * 输入：date = "2004-03-01"
     * 输出：61
     * @param date
     * @return
     */

    private final String[] months = {
            "01","02","03","04","05","06",
            "07","08","09","10","11","12"
    };

    private final String[] days = {
            "01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30","31"
    };


    public int dayOfYear(String date) {
        int res = 0;
        String[] split = date.split("-");
        int month = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(split[1])) {
                month = i + 1;
                break;
            }
        }
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                res += 31;
            } else if (i == 2) {
                int year = Integer.parseInt(split[0]);
                // 区分闰年，四年一闰，百年不闰，四百年再闰
                if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                    res += 29;
                } else {
                    res += 28;
                }
            } else {
                res += 30;
            }
        }
        int day = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(split[2])) {
                day = i;
                break;
            }
        }
        res += day + 1;
        return res;
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        int ans = dayOfYear.dayOfYear("1900-03-25");
        System.out.println(ans);
    }


}
