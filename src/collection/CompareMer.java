package collection;

import charactor.Hero;

import java.util.*;

/**
 * @author: Frank
 * @Date: 2017/11/13 16:37
 */
public class CompareMer {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero"+i,r.nextInt(100),r.nextInt(100)));
        }
        System.out.println(heros);
        Comparator<Hero> c = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (o1.hp>o2.hp){
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        Collections.sort(heros,c);
        System.out.println(heros);
    }
}
