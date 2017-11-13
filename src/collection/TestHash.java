package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author: Frank
 * @Date: 2017/10/30 16:54
 */
public class TestHash {
    private static int NUMBERAMOUNT = 3000000;

    public static int getName() {
        return (int) (Math.random() * 9000 + 1000);
    }

    /**
     * 通过哈希树来查找
     *
     * @return 返回包含此名字的list
     */
    public static List<Hero> getByMap(HashMap<String, List<Hero>> m) {
        long a = System.currentTimeMillis();
        List<Hero> result = new ArrayList<>();
        result = m.get("hero-5555");
        long b = System.currentTimeMillis();
        System.out.printf("通过map查找，一共找到%d个英雄，耗时%d毫秒%n", result.size(), (b - a));
        return result;
    }

    private static List<Hero> getByIteration(List<Hero> h) {
        List<Hero> result = new ArrayList<>();
        long a = System.currentTimeMillis();
        for (Hero hero :
                h) {
            if ("hero-5555".equals(hero.name)) {
                result.add(hero);
            }
        }
        long b = System.currentTimeMillis();
        System.out.printf("一共找到%d个英雄，一共耗时%d毫秒%n",result.size(),b-a);
        return result;
    }

    public static void main(String[] args) {
        //生成对象
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < NUMBERAMOUNT; i++) {
            Hero h = new Hero("hero-" + getName());
            heroes.add(h);
        }
        //构建hash树,把相同名字的放在一个hash里面
        HashMap<String, List<Hero>> heroMap = new HashMap<>();
        long a = System.currentTimeMillis();
        for (Hero h :
                heroes) {
            List<Hero> list = heroMap.get(h.name);
            //如果没有找到，就重新生成一个
            if (list == null) {
                list = new ArrayList<>();
                heroMap.put(h.name, list);
            }
            list.add(h);
        }
        long b = System.currentTimeMillis();
        System.out.println((b-a)+"毫秒");
        //查找对象
        System.out.println("开始查找对象");
        getByMap(heroMap);
        getByIteration(heroes);
    }
}
