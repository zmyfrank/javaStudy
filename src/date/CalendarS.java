package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarS {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Calendar s = Calendar.getInstance();
        Date d = s.getTime();
        //Date d2 = new Date(0);
        s.setTime(d);
        System.out.println("当前日期： \t" + sdf.format(d));
        //下个月的今天
        s.setTime(d);
        s.add(Calendar.MONTH, 1);
        System.out.println("下个月的今天是： \t" + sdf.format(s.getTime()));
        //去年的今天
        s.setTime(d);
        s.add(Calendar.YEAR,-1);
        System.out.println("全年的今天是: \t"+sdf.format(s.getTime()));
        //上个月第三天
        s.setTime(d);
        s.add(Calendar.MONTH,-1);
        s.add(Calendar.DATE,3);
        System.out.println("上个月的第三天是： \t"+sdf.format(s.getTime()));
        s.setTime(d);
        s.add(Calendar.MONTH,1);
        s.add(Calendar.DATE,-3);
        System.out.println("下个月的倒数第三天是： \t"+sdf.format(s.getTime()));
    }
}
