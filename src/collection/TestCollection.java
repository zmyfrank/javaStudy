package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;

public class TestCollection {
    public static void deleteEight(List<Hero> hArL){
        int i = 0;
        for (int j = 0; j < hArL.size(); j++) {
            //去掉等于8的对象
            if (j % 8 == 0) {
                hArL.remove(j+i);
                deleteEight(hArL);
            }
        }
    }
    public static void main(String[] args) {
        List<Hero> generichero = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            generichero.add(new Hero("Hero" + i));
        }
        System.out.println(0 % 8);
        deleteEight(generichero);
        for (Hero h :
                generichero) {
            System.out.println(h);
        }

    }

}
