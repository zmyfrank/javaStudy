package collection;


import charactor.Hero;

import java.util.*;

/**
 * @author: Frank
 * @Date: 2017/10/31 11:31
 */
public class TestHashSet {
    public static int hashCode(String string) {
        if (string.length() == 0) {
            return 0;
        } else {
            char[] chars = string.toCharArray();
            int hashcode = 0;
            for (char aChar : chars) {
                hashcode += aChar;
            }
            hashcode *= 23;
            //小于0取绝对值
            hashcode = hashcode < 0 ? -hashcode : hashcode;
            //保证在2000内
            hashcode %= 2000;
            return hashcode;
        }
    }

    private static String random(int length) {
        //生成含有所有字母数字的池
        StringBuilder pool = new StringBuilder();
        for (short i = '0'; i < '9'; i++) {
            pool.append((char) i);
        }
        for (short i = 'a'; i < 'z'; i++) {
            pool.append((char) i);
        }
        for (short i = 'A'; i < 'Z'; i++) {
            pool.append((char) i);
        }
        //随机取出
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int j = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(j);
        }
        //返回string
        return new String(cs);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int j = (int) (Math.random() * 8 +2);
            String str = random(j);
            int code = hashCode(str);
            System.out.println(code);
        }
    }
}
