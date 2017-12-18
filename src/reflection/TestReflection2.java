package reflection;

import charactor.Hero;

import java.lang.reflect.Field;

/**
 * @author: Frank
 * @Date: 2017/12/18 16:25
 */
public class TestReflection2 {
    public static void main(String[] args) {
        Hero h = new Hero("xiaotimo");
        try {
            Field f1 = h.getClass().getDeclaredField("name");
            f1.set(h,"datimo");
            System.out.println(h);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
