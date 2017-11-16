package multiplethread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/16 9:55
 */
public class MultipleEntry {
    public static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

    public static void main(String[] args) {
        List<String> passworlds = new ArrayList<>();
        String passWorld = randomString(9);
        System.out.println("随机生成的密码是"+passWorld);
        new ExhaustivePassword(passworlds,passWorld).start();
        //new LogThread(passworlds).run();
    }
}
