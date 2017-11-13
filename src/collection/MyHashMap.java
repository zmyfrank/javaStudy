package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/13 15:35
 */

public class MyHashMap implements IHashMap {
    //定义接收数组
    private static List<List> hashMap = new ArrayList<>(2000);
    @Override
    public void put(String key, Object value) {
        int code = TestHashSet.hashCode(key);
        if (hashMap.get(code) ==null){
            LinkedList<Object> mapInside = new LinkedList<>();
            mapInside.add(value);
        }else {
            hashMap.get(code).add(value);
        }
    }

    @Override
    public Object get(String key) {
        return null;
    }

    public static void main(String[] args) {

    }
}
