package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/22 17:20
 */
public class NetWorkH {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println(list.subList(0,5));
        System.out.println(list.subList(5,10));
    }
}
