package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/10/30 14:58
 */

public class NodeHero {
    public NodeHero heroLeft;
    public NodeHero heroright;
    public Hero value;
    private static int HEROAMOUNT = 10;

    /**
     * 组件英雄树的方法
     *
     * @param h 出入当前hero
     */
    public void addHero(Hero h) {
        if (null == value) {
            value = h;
        } else {
            if (value.hp >= h.hp) {
                if (heroLeft == null) {
                    heroLeft = new NodeHero();
                }
                heroLeft.addHero(h);
            } else {
                if (heroright == null) {
                    heroright = new NodeHero();
                }
                heroright.addHero(h);
            }
        }
    }

    /**
     * 英雄的排序方法，两个一起排就行了
     *
     * @return 英雄的排序
     */
    public List<Object> heroValues() {
        List<Object> heros = new ArrayList<>();
        if (heroLeft != null) {
            heros.addAll(heroLeft.heroValues());
        }
        heros.add(value);
        if (heroright != null) {
            heros.addAll(heroright.heroValues());
        }
        return heros;
    }

    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < HEROAMOUNT; i++) {
            float heroHp = (float) (Math.random() * 900 + 100);
            Hero hero = new Hero("Hero" + i, heroHp);
            heros.add(hero);
        }
        System.out.println(heros);
        NodeHero root = new NodeHero();
        for (Hero h :
                heros) {
            root.addHero(h);
        }
        System.out.println("根据血量初始化之后");
        List<Object> hLast = root.heroValues();
        System.out.println(hLast);
    }
}
