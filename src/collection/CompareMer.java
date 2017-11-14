package collection;

import charactor.Hero;

import java.util.*;

/**
 * @author: Frank
 * @Date: 2017/11/13 16:37
 * filter 匹配
distinct 去除重复(根据equals判断)
sorted 自然排序
sorted(Comparator<T>) 指定排序
limit 保留
skip 忽略
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
        heros.sort(CompareMer::matched);
        System.out.println(heros);
    }
}
