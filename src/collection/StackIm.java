package collection;

import charactor.Hero;

import java.util.LinkedList;

/**
 * @author: Frank
 * @Date: 2017/10/30 10:28
 */
public class StackIm implements Stack {
    private LinkedList<Hero> heroes = new LinkedList<>();

    @Override
    public void push(Hero h) {
        heroes.addLast(h);
    }

    @Override
    public Hero pull() {
        return heroes.removeLast();
    }

    @Override
    public Hero peek() {
        return heroes.getLast();
    }

    public static void main(String[] args) {
        StackIm heroStack = new StackIm();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero("frank" + i);
            System.out.println("压入英雄" + hero);
            heroStack.push(hero);
        }
        for (int i = 0; i < 10; i++) {
            Hero h = heroStack.pull();
            System.out.println("弹出 hero" + h);
        }
    }
}
