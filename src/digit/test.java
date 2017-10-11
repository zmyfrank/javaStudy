package digit;

public class test extends TestNumber {
    public static void main(String[] args) {
        MyStringBuffer js = new MyStringBuffer(getRandomString(10));
        StringBuilder initialValue2 = new StringBuilder(getRandomString(10));
        int j = 0;
        int k = 0;
        long time1 = System.currentTimeMillis();
        while (j < 100000) {
            js.append(getRandomString(1));
            j++;
        }
        long time2 = System.currentTimeMillis();
        while (k < 100000) {
            initialValue2.append(getRandomString(1));
            k++;
        }
        long time3 = System.currentTimeMillis();
        System.out.println(js.toString());
        System.out.println("string耗费的时间为" + (time2 - time1));
        System.out.println("buffer耗费的时间为" + (time3 - time2));
    }
}
