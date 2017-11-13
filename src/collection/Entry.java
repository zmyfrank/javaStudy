package collection;

/**
 * @author: Frank
 * @Date: 2017/11/13 15:32
 */
public class Entry {
    public Entry(Object key,Object value){
        super();
        this.key = key;
        this.value = value;
    }
    public Object key;
    public Object value;
    @Override
    public String toString(){
        return "[key="+key+",value="+value+"]";
    }
}
