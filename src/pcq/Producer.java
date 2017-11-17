package pcq;

import java.util.LinkedList;

/**
 * @author: Frank
 * @Date: 2017/11/16 17:08
 */
public class Producer extends Thread {
    private Mylist<Character> list;

    public Producer(Mylist<Character> list) {
        this.list = list;
    }

    private static Character randomString() {
        String poll = "";
        for (short i = 'A'; i < 'Z'; i++) {
            poll += i;
        }
        char[] chars = poll.toCharArray();
        char c = chars[((int) (Math.random() * chars.length))];
        return c;
    }

    @Override
    public void run() {
        while (true) {
            char c = randomString();
            System.out.println("压入"+c);
            list.push(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
