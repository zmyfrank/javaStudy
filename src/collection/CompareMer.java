package collection;

import charactor.Hero;

import java.util.*;

/**
 * @author: Frank
 * @Date: 2017/11/13 16:37
 */
public class CompareMer {
    public static int matched(Hero o1,Hero o2){
        return o1.hp >= o2.hp ? 1 : -1;
    }
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(100), r.nextInt(100)));
        }
        ArrayList<Hero> heroes = new ArrayList<>();
        System.out.println(heros);
        Collections.sort(heros,matched());
        System.out.println(heros);
    }
}
