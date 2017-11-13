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
    private LinkedList<Entry>[] values = new LinkedList[2000];
    @Override
    public void put(String key, Object value) {
        int code = TestHashSet.hashCode(key);
        //直接取
        LinkedList<Entry> list = values[code];
        //如果取不到就新建
        if (list ==null){
           list = new LinkedList<>();
           values[code] = list;
        }
        boolean found = false;
        //遍历，如果有就覆盖
        for (Entry entry :
                list) {
            if (key.equals(entry.value)){
                entry.value = value;
                found = true;
                break;
            }
        }
        //如果没有，就创建新的entry
        if (!found){
            Entry entry = new Entry(key,value);
            list.add(entry);
        }

    }

    @Override
    public Object get(String key) {
        //把key变为hash key
        int hashCode = TestHashSet.hashCode(key);
        LinkedList<Entry> list = values[hashCode];
        //处理没有的情况
        if (list == null){
            return null;
        }
        //result为返回的数据
        Object result = null;
        for (Entry entry :
                list) {
            //遍历，找到了就直接返回
            if (key.equals(entry.key)){
                result = entry.value;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Entry> list = new ArrayList<>();
    }
}
