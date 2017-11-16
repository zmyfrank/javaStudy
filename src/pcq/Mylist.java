package pcq;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author: Frank
 * @Date: 2017/11/16 16:51
 */
public class Mylist<T> {
    private LinkedList<T> list = new LinkedList<>();

    public Mylist() {
        Collections.synchronizedList(list);
    }

    public T pull() {
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeLast();
        this.notify();
        return t;
    }

    public void push(T t) {
        while (list.size() == 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.addLast(t);
    }

    public T peek() {
        return list.getLast();
    }
}
