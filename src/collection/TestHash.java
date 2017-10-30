package collection;

import charactor.Hero;

import java.util.Random;

/**
 * @author: Frank
 * @Date: 2017/10/30 16:54
 */
public class TestHash {
    public static int NUMBERAMOUNT = 3000000;
    public static int STRINGLENGTH = 4;
    public static String getName() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < STRINGLENGTH; i++) {
            name.append((int) (Random * 10));

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUMBERAMOUNT; i++) {
            String number = "" + (int)(Math.random() * 10);
            Hero hero = new Hero("");
        }
    }
}
