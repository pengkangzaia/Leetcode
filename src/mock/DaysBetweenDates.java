package mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @FileName: DaysBetweenDates.java
 * @Description: DaysBetweenDates.java类说明
 * @Author: admin
 * @Date: 2021/2/13 9:28
 */
public class DaysBetweenDates {


    public int daysBetweenDates(String date1, String date2) {
        LocalDate t1 = LocalDate.parse(date1);
        LocalDate t2 = LocalDate.parse(date2);
        return (int) Math.abs(t1.until(t2, ChronoUnit.DAYS));
    }

    private int daysCount(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = sdf.parse(date1);
        Date time2 = sdf.parse(date2);
        return (int) ((time1.getTime() - time2.getTime()) / (365*24*60*60));
    }

}
