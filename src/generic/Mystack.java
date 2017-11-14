package generic;

import java.util.LinkedList;

/**
 * @author: Frank
 * @Date: 2017/11/14 14:37
 */
public class Mystack<T> {
    LinkedList<T> list = new LinkedList<>();
    public T pull(){
        return list.removeLast();
    }
    public void push(T t){
        list.addLast(t);
    }
    public T peek(){
        return list.getLast();
    }
}
