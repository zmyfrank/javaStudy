package pcq;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author: Frank
 * @Date: 2017/11/16 16:51
 */
public class Mylist<T> {
    private LinkedList<T> list = new LinkedList<>();


    public synchronized T pull() {
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return list.removeLast();
    }

    public synchronized void push(T t) {
        while (list.size() == 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        list.addLast(t);
    }

    public T peek() {
        return list.getLast();
    }
}
