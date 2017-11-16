package pcq;

import java.util.LinkedList;

import static javafx.scene.input.KeyCode.T;

/**
 * @author: Frank
 * @Date: 2017/11/16 17:26
 */
public class Entry {
    public static void main(String[] args) {
        Mylist<Character> list = new Mylist<>();
        //Mylist Mylist=new Mylist<>();
        for (int i = 0; i < 2; i++) {
            new Producer(list).start();
        }
        for (int i = 0; i < 3; i++) {
            new Consumer(list).start();
        }
    }
}
