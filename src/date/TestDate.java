package date;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static long getTime(String str) {
        Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            d = sdf.parse(str);
            return d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long cheackTime(long time1, long time2) {
        long time3 = (long) Math.random() * time2;
        if (time3 > time1) {
            return time3;
        }else {
            cheackTime(time1,time2);
        }
        return time3;
    }

    public static void main(String[] args) {
        long time1 = getTime("1995/01/01 00:00:00");
        long time2 = getTime("1995/12/31 23:59:59");
        System.out.println("起始时间是" + time1);
        System.out.println("结束时间是" + time2);
        long time3 = cheackTime(time1, time2);
        Date d = new Date(time3);
        System.out.println(d);
    }
}
