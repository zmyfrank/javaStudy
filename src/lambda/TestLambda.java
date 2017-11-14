package lambda;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author: Frank
 * @Date: 2017/11/14 16:05
 */
public class TestLambda {
    public static void main(String[] args) {
        List list1 = getList(ArrayList::new);
        System.out.println(list1);
    }

    public static List getList(Supplier<List> s) {
        return s.get();
    }
}
