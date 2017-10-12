package date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TestDate {
    //转换毫秒
    private static long getTime(String str) {
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

    //对比生成对应时间
    private static long cheackTime(long time1, long time2) {
        long time3 = (long) (Math.random() * time2);
        while (time3 < time1) {
            time3 = (long) (Math.random() * time2);
        }
        return time3;
    }

    //生成时间数组
    private static long[] getRealTime(String[] strA) {
        long[] resultStringA = new long[strA.length];
        for (int i = 0; i < strA.length; i++) {
            //用来存放时间的变量
            StringBuilder a = new StringBuilder();
            String n = strA[i].substring(10);
            String[] s = n.split(":");
            for (String value : s) {
                a.append(value.trim());
            }
            resultStringA[i] = Integer.parseInt(new String(a));
        }
        return resultStringA;
    }

    public static void main(String[] args) {
        //储存日期的数组
        long[] dateArray = new long[9];
        String[] resultDate = new String[9];
        //生成日期
        long time1 = getTime("1970/01/01 08:00:00");
        long time2 = getTime("2000/12/31 23:59:59");
        System.out.println("起始时间是" + time1);
        System.out.println("结束时间是" + time2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < dateArray.length; i++) {
            resultDate[i] = sdf.format(cheackTime(time1, time2));
            dateArray[i] = cheackTime(time1, time2);
        }
        System.out.println("排序前的时间" + Arrays.toString(resultDate));
        //生成时间数字
        long[] s = (getRealTime(resultDate));
        //冒泡排序
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i+1; j < s.length; j++) {
                long temp = s[i];
                String temp2 = resultDate[i];
                if (s[j] < s[i]) {
                    s[i] = s[j];
                    s[j] = temp;
                    resultDate[i] = resultDate[j];
                    resultDate[j] = temp2;
                }
            }
        }
        System.out.println("排序后的时间"+Arrays.toString(resultDate));
    }
}
